package by.barouski.online.store.repo;

import by.barouski.online.store.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
}
