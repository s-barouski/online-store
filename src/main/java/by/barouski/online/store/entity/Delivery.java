package by.barouski.online.store.entity;

import org.springframework.data.annotation.Id;

public class Delivery {
    @Id
    private long id;
    private long date;
    private String deliveryType;
    private long deliveryCost;

    public Delivery() {
    }

    public Delivery(long id, long date, String deliveryType, long deliveryCost) {
        this.id = id;
        this.date = date;
        this.deliveryType = deliveryType;
        this.deliveryCost = deliveryCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public long getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(long deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
