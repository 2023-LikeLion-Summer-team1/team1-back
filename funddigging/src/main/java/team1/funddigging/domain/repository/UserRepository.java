package team1.funddigging.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team1.funddigging.domain.entity.Member;


public interface UserRepository extends JpaRepository<Member, Long> {
}
