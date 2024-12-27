package by.barouski.online.store.repo;

import by.barouski.online.store.entity.CartOfOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartOfOrdersRepository extends JpaRepository<CartOfOrders, Long>{
}
