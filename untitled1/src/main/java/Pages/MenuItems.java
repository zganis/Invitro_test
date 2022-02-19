package Pages;

/*
    Пункты меню
 */
public enum MenuItems {
    ADDRESS("Адрес"), ANALYSIS("Анализы"), PROMOTION("Акции"), WRITE_TO_DOCTOR("Запись к врачу");

    private String resources;

    MenuItems(String resources) {
        this.resources = resources;
    }

    public String getResources() {
        return resources;
    }
}