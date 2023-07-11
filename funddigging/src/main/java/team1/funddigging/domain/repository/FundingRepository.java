package team1.funddigging.domain.repository;

import team1.funddigging.domain.entity.Funding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundingRepository extends JpaRepository<Funding, Long> {

}
