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
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long authority_id;
    @Column(name ="name")
    private String name;

//    @ManyToMany(mappedBy = "authorities")
//    private List<Buyer> buyers;
    @ManyToMany
    @JoinTable(name="buyer_authority",
            joinColumns=  @JoinColumn(name="authority_id", referencedColumnName="authority_id"),
            inverseJoinColumns= @JoinColumn(name="buyer_id", referencedColumnName="buyer_id") )
    private List<Buyer> buyers;


}
