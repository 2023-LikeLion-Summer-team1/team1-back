package team1.funddigging.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team1.funddigging.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
