package by.barouski.online.store.entity;

import org.springframework.data.annotation.Id;

public class Order {
    @Id
    private long id;
    private long date;
    private long totalCost;

    public Order() {
    }

    public Order(long id, long date, long totalCost) {
        this.id = id;
        this.date = date;
        this.totalCost = totalCost;
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

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
}
