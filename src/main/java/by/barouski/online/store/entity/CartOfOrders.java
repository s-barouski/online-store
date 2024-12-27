package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class CartOfOrders {
    @Id
    private long cartId;
    private int quantityOfGoods;
    private float totalCost;


    public CartOfOrders(float totalCost) {
        this.totalCost = totalCost;
    }

    public CartOfOrders(long cartId, int quantityOfGoods, float totalCost) {
        this.cartId = cartId;
        this.quantityOfGoods = quantityOfGoods;
        this.totalCost = totalCost;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        this.quantityOfGoods = quantityOfGoods;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
