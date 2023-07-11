package team1.funddigging.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import team1.funddigging.application.dto.FundingDto;
//import com.likelion.backend.domain.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE funding SET deleted = true WHERE funding_id = ?")
public class Funding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funding_id;

    private Double goal_amount;

    private Integer is_active;

    private String created_date;

    private String title;

    private String description;

    private Double price;

    private String start_date;

    private String end_date;

    private String image;

    private Integer like_num;

    private String funding_title;

    /*
    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ReserveRecord> reservedRoomList = new ArrayList<>();
    */


    public static Funding toFunding(FundingDto dto) {

        return Funding.builder()
                .goal_amount(dto.getGoal_amount())
                .is_active(dto.getIs_active())
                .created_date(dto.getCreated_date())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .start_date(dto.getStart_date())
                .end_date(dto.getEnd_date())
                .image(dto.getImage())
                .like_num(dto.getLike_num())
                .funding_title(dto.getFunding_title())
                .build();
    }


}
