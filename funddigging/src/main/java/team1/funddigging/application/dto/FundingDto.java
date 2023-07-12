package team1.funddigging.application.dto;

import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.Member;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundingDto {


    private Long funding_id;

    private Member seller_user_id;

    private Room room_id;

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

    public static RoomDto from(ChangeRoomInfoRequest request) {
        return RoomDto.builder()
                .id(request.getId())
                .name(request.getName())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();
    }

     */


    public static FundingDto from(Funding funding) {
        return FundingDto.builder()
                .funding_id(funding.getFunding_id())
                .room_id(funding.getRoom_id())
                .seller_user_id(funding.getSeller_user_id())
                .funding_title(funding.getFunding_title())
                .title_image(funding.getTitle_image())
                .goal_amount(funding.getGoal_amount())
                .price(funding.getPrice())
                .description(funding.getDescription())
                .funding_image(funding.getFunding_image())
                .funding_budget(funding.getFunding_budget())
                .funding_schedule(funding.getFunding_schedule())
                .team_introduction(funding.getTeam_introduction())
                .created_date(funding.getCreated_date())
                .start_date(funding.getStart_date())
                .end_date(funding.getEnd_date())
                .budget_date(funding.getBudget_date())
                .like_num(funding.getLike_num())
                .is_active(funding.getIs_active())
                .build();
    }





    public static FundingDto toAdd(AddFundingRequest request) {
        return FundingDto.builder()
                .funding_title(request.getFunding_title())
                .title_image(request.getTitle_image())
                .goal_amount(request.getGoal_amount())
                .price(request.getPrice())
                .description(request.getDescription())
                .funding_image(request.getFunding_image())
                .funding_budget(request.getFunding_budget())
                .funding_schedule(request.getFunding_schedule())
                .team_introduction(request.getTeam_introduction())
                .created_date(request.getCreated_date())
                .start_date(request.getStart_date())
                .end_date(request.getEnd_date())
                .like_num(0)
                .is_active(0)
                .build();
    }


}
