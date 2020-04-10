import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        boolean isNotEnd = true;
        while (isNotEnd) {
            isNotEnd = run();
        }
    }

    private static boolean run() {
        OutputView.printCommand();
        Command command = Command.of(InputView.inputCommand());
        if (command == Command.ORDER) {
            order();
        }

        if (command == Command.PAY) {
            pay();
        }

        if (command == Command.END) {
            return false;
        }

        return true;
    }

    private static void order() {
        Tables tables = new Tables(TableRepository.tables());
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        Menus menus = new Menus(MenuRepository.menus());
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();
        final int menuAmount = InputView.inputAmount();

        tables.addOrderToTable(tableNumber, menus.of(menuNumber), menuAmount);
    }

    private static void pay() {
        final Tables tables = new Tables(TableRepository.tables());
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        Map<Menu, Integer> orderHistory = tables.of(tableNumber).getOrderHistory();
        OutputView.printOrderistory(makeOrderHistory(orderHistory));

        Price totalPrice = Payment.calculateTotalPrice(tables.of(tableNumber).getOrderHistory());
        final PaymentMethod paymentMethod = PaymentMethod.of(InputView.inputPaymentMethod());
        if (paymentMethod == PaymentMethod.CASH) {
            totalPrice = Payment.discountCash(totalPrice);
        }

        OutputView.printTotalPrice(totalPrice);
        tables.pay(tableNumber);
    }

    private static List<OrderDto> makeOrderHistory(final Map<Menu, Integer> orderHistory) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Map.Entry<Menu, Integer> entry : orderHistory.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            OrderDto orderDto = new OrderDto();
            orderDto.setMenuName(menu.getName());
            orderDto.setCount(count);
            orderDto.setTotalPrice(menu.getPrice().multiply(count));
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }
}
