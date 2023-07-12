package team1.funddigging.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import team1.funddigging.application.dto.FundingDto;
//import com.likelion.backend.domain.entity.common.BaseEntity;
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
public class Funding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funding_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Member seller_user_id;


    private String funding_title;

    private String title_image;

    private Double goal_amount;

    private Double price;

    private String description;

    private String funding_image;

    private String funding_budget;

    private String funding_schedule;

    private String team_introduction;

    private String created_date;

    private String start_date;

    private String end_date;

    private String budget_date;

    private Integer like_num;

    private Integer is_active;





    /*
    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ReserveRecord> reservedRoomList = new ArrayList<>();
    */



    public static Funding toFunding(FundingDto dto, Room room, Member user) {



        return Funding.builder()
                .room_id(room)
                .seller_user_id(user)
                .funding_title(dto.getFunding_title())
                .title_image(dto.getTitle_image())
                .goal_amount(dto.getGoal_amount())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .funding_image(dto.getFunding_image())
                .funding_budget(dto.getFunding_budget())
                .funding_schedule(dto.getFunding_schedule())
                .team_introduction(dto.getTeam_introduction())
                .created_date(dto.getCreated_date())
                .start_date(dto.getStart_date())
                .end_date(dto.getEnd_date())
                .budget_date(dto.getBudget_date())
                .like_num(dto.getLike_num())
                .is_active(dto.getIs_active())
                .build();


    }





}
