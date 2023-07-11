package team1.funddigging.presentation.response;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.Funding;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundingInfoResponse {

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

    public static FundingInfoResponse from (FundingDto fundingDto){
        return FundingInfoResponse.builder()
                .funding_id(fundingDto.getFunding_id())
                .goal_amount(fundingDto.getGoal_amount())
                .is_active(fundingDto.getIs_active())
                .created_date(fundingDto.getCreated_date())
                .title(fundingDto.getTitle())
                .description(fundingDto.getDescription())
                .price(fundingDto.getPrice())
                .start_date(fundingDto.getStart_date())
                .end_date(fundingDto.getEnd_date())
                .image(fundingDto.getImage())
                .like_num(fundingDto.getLike_num())
                .funding_title(fundingDto.getFunding_title())
                .build();
    }

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

                /*
                .id(funding.getId())
                .name(funding.getName())
                .capacity(funding.getCapacity())
                .description(funding.getDescription())
                .build();
                 */
    }


}
