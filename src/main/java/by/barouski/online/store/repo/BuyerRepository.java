package by.barouski.online.store.repo;

import by.barouski.online.store.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
