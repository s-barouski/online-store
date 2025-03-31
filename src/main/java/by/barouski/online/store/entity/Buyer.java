package by.barouski.online.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email")
    private String email;


    @ManyToMany
    @JoinTable(
            name = "buyer_authority",
            joinColumns = @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "authority_id")
    )
    private List<Authority> authorities;

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private OrderHistory orderHistory;

    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL)
    private CartOfOrder cartOfOrder;

}