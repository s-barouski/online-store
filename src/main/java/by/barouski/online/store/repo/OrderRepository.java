package by.barouski.online.store.repo;

import by.barouski.online.store.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Ordering, Long> {
}
