package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cart_of_order")
public class CartOfOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "quantity_of_goods")
    private int quantityOfGoods;
    @Column(name = "total_cost")
    private float totalCost;

    @ManyToMany
    @JoinTable(name="cart_of_orders_products",
            joinColumns=  @JoinColumn(name="cart_of_order_id", referencedColumnName="cart_id"),
            inverseJoinColumns= @JoinColumn(name="product_id", referencedColumnName="product_id"))
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
    private Buyer buyer;




}
