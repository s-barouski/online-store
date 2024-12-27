package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class Order {
    @Id
    private long orderId;
    private long date;
    private long totalCost;

    public Order() {
    }

    public Order(long orderId, long date, long totalCost) {
        this.orderId = orderId;
        this.date = date;
        this.totalCost = totalCost;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
}
