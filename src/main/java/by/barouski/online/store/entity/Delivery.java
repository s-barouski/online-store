package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class Delivery {
    @Id
    private long deliveryId;
    private long date;
    private String deliveryType;
    private long deliveryCost;
    private String address;

    public Delivery(String address) {
        this.address = address;
    }

    public Delivery(long deliveryId, long date, String deliveryType, long deliveryCost, String address) {
        this.deliveryId = deliveryId;
        this.date = date;
        this.deliveryType = deliveryType;
        this.deliveryCost = deliveryCost;
        this.address = address;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
