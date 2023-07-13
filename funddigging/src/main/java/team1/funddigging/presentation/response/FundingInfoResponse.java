package team1.funddigging.presentation.response;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.Funding;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundingInfoResponse {

    private Long funding_id;
    //private User seller_user_id;
    private Long room_id;
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

    private String seller_name;
    private String seller_image;


    private String category_name;

    private String host_name;
    private String host_title_image;

    private Double current_amount;
    private Integer backers_count;
    private Double progress;



    public static FundingInfoResponse fromOneFunding (Funding funding){
        return FundingInfoResponse.builder()
                .funding_id(funding.getFunding_id())
                .room_id(funding.getRoom_id().getRoom_id())
                //.seller_user_id(funding.getSeller_user_id())
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
                .seller_name(funding.getSeller_user_id().getName())
                .category_name(funding.getRoom_id().getCategory_id().getName())
                .backers_count(funding.getBackers_count())
                .current_amount(funding.getCurrent_amount())
                .progress(funding.getProgress())
                .seller_image(funding.getSeller_user_id().getUser_image())
                .host_name(funding.getRoom_id().getHost_name())
                .host_title_image(funding.getRoom_id().getTitle_image())
                .build();
    }


    public static FundingInfoResponse from (FundingDto fundingDto){
        return FundingInfoResponse.builder()
                .funding_id(fundingDto.getFunding_id())
                .room_id(fundingDto.getRoom_id().getRoom_id())
                .funding_title(fundingDto.getFunding_title())
                .title_image(fundingDto.getTitle_image())
                .goal_amount(fundingDto.getGoal_amount())
                .price(fundingDto.getPrice())
                .description(fundingDto.getDescription())
                .funding_image(fundingDto.getFunding_image())
                .funding_budget(fundingDto.getFunding_budget())
                .funding_schedule(fundingDto.getFunding_schedule())
                .team_introduction(fundingDto.getTeam_introduction())
                .created_date(fundingDto.getCreated_date())
                .start_date(fundingDto.getStart_date())
                .end_date(fundingDto.getEnd_date())
                .budget_date(fundingDto.getBudget_date())
                .like_num(fundingDto.getLike_num())
                .is_active(fundingDto.getIs_active())
                .seller_name(fundingDto.getSeller_user_id().getName())
                .category_name(fundingDto.getRoom_id().getCategory_id().getName())
                .backers_count(fundingDto.getBackers_count())
                .current_amount(fundingDto.getCurrent_amount())
                .progress(fundingDto.getProgress())
                .seller_image(fundingDto.getSeller_user_id().getUser_image())
                .host_name(fundingDto.getRoom_id().getHost_name())
                .host_title_image(fundingDto.getRoom_id().getTitle_image())
                .build();
    }

    /*

    public static FundingInfoResponse from (Funding funding){
        return FundingInfoResponse.builder()
                .funding_id(funding.getFunding_id())
                .goal_amount(funding.getGoal_amount())
                .is_active(funding.getIs_active())
                .created_date(funding.getCreated_date())
                .title(funding.getTitle())
                .description(funding.getDescription())
                .price(funding.getPrice())
                .start_date(funding.getStart_date())
                .end_date(funding.getEnd_date())
                .image(funding.getImage())
                .like_num(funding.getLike_num())
                .funding_title(funding.getFunding_title())
                .build();


                .id(funding.getId())
                .name(funding.getName())
                .capacity(funding.getCapacity())
                .description(funding.getDescription())
                .build();

    }

     */



}
