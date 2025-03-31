package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id")
    private Long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Float price;
    @Column(name = "quantity")
    private Integer quantity;
//    @Column(name = "image_path")
//    protected String imagePath;

    @ManyToMany
    @JoinTable(name="cart_of_orders_products",
            joinColumns=  @JoinColumn(name="product_id", referencedColumnName="product_id"),
            inverseJoinColumns= @JoinColumn(name="cart_of_order_id", referencedColumnName="cart_of_order_id"))
    private List<CartOfOrder> cartOfOrders;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> imageList = new ArrayList<>();

    }






