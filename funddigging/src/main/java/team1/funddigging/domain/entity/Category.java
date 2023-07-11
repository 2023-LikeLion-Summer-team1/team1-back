package team1.funddigging.domain.entity;


//import com.likelion.backend.domain.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE funding SET deleted = true WHERE funding_id = ?")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Category_id;

        private String name;



}
