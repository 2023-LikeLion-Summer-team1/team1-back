package team1.funddigging.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.Funding;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
