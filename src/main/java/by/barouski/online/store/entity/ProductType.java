package by.barouski.online.store.entity;

public enum ProductType {
    HOUSEHOLD_INSTRUMENTATION ("Бытовые приборы"),
    COMPUTER_EQUIPMENT ("Компьютерная техника"),
    SMARTPHONES ("Смартфоны"),
    CLIMATE_CONTROL_EQUIPMENT ("Климатическое обоудование"),
    AUXILIARY_DEVICES ("Вспомогательные устройства");

    private String description;

    ProductType(String description) {
    }
    public String getDescription(){
        return description;
    }
}
