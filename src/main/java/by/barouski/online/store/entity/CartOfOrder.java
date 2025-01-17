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
    @Column(name = "quantityOfGoods")
    private int quantityOfGoods;
    @Column(name = "totalCost")
    private float totalCost;

    @ManyToMany
    private List<Product> products;

    @OneToOne
    private Buyer buyer;



}
