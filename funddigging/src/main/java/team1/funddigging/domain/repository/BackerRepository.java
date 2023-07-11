package team1.funddigging.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team1.funddigging.domain.entity.Backer;
import team1.funddigging.domain.entity.Category;

public interface BackerRepository extends JpaRepository<Backer, Long> {
}
