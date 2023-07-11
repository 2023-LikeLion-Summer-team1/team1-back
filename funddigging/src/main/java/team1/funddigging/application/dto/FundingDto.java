package team1.funddigging.application.dto;

import team1.funddigging.domain.entity.Funding;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundingDto {
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
    }


    public static FundingDto toAdd(AddFundingRequest request) {

        return FundingDto.builder()
                .goal_amount(request.getGoal_amount())
                .is_active(0)
                .created_date(request.getCreated_date())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .start_date(request.getStart_date())
                .end_date(request.getEnd_date())
                .image(request.getImage())
                .like_num(0)
                .funding_title(request.getFunding_title())
                .build();
    }
}
