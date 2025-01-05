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
@Setter
@Getter
public class Buyer {
    @Id

    private Long buyerId;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;

    @ManyToMany
    private List<Authority> authorities;

    @OneToOne
    private OrderHistory orderHistory;

}
