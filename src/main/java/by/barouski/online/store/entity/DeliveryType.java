package by.barouski.online.store.entity;

public enum DeliveryType {
    ON_FOOT("Доставка пешком"),
    AUTO("Доставка автомобильная"),
    POST("Доставка на почту");


    private String description;

    DeliveryType(String description) {
    }

    public String getDescription() {
        return description;
    }
}

