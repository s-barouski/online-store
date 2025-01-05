package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
public class CartOfOrders {
    @Id
    private Long cartId;
    private int quantityOfGoods;
    private float totalCost;

    @ManyToMany
    private List<Product> products;

    @OneToOne
    private Buyer buyer;



}
