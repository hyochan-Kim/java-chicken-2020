package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {
    private Map<Integer, Menu> menus = new HashMap<>();

    public Menus(final List<Menu> menus) {
        for (Menu menu : menus) {
            this.menus.put(menu.getNumber(), menu);
        }
    }

    public Menu of(int menuNumber) {
        return menus.get(menuNumber);
    }

    public Map<Integer, Menu> getMenus() {
        return menus;
    }
}
