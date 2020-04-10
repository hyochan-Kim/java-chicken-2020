package view;

import domain.*;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String UNPAID_BOTTOM_LINE = "└ W ┘";

    public static void printCommand() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문 등록");
        System.out.println("2 - 결제 하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final Tables tables) {
        System.out.println("## 테이블 목록");
        printTopLine(tables.size());
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final Menus menus) {
        for (final Menu menu : menus.getMenus().values()) {
            System.out.println(menu);
        }
    }

    public static void printOrderistory(final List<OrderDto> orderDtos) {
        System.out.println("## 주문 내역");
        for (OrderDto orderDto : orderDtos) {
            System.out.println(orderDto.getMenuName() + " " + orderDto.getCount() + " " + orderDto.getTotalPrice());
        }
    }

    public static void printTotalPrice(final Price price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price + "원");
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(final Tables tables) {
        for (final Table table : tables.values()) {
            System.out.print(selectBottomLine(table));
        }
        System.out.println();
    }

    private static String selectBottomLine(final Table table) {
        if (table.hasUnpaidOrder()) {
            return UNPAID_BOTTOM_LINE;
        }
        return BOTTOM_LINE;
    }

    private static void printTableNumbers(final Tables tables) {
        for (final Table table : tables.values()) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
