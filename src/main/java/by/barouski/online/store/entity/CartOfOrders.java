package by.barouski.online.store.entity;

import org.springframework.data.annotation.Id;

public class CartOfOrders {
    @Id
    private long id;
    private int quantityOfGoods;

    public CartOfOrders() {
    }

    public CartOfOrders(long id, int quantityOfGoods) {
        this.id = id;
        this.quantityOfGoods = quantityOfGoods;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        this.quantityOfGoods = quantityOfGoods;
    }
}
