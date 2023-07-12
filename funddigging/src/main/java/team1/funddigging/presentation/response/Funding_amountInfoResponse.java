package team1.funddigging.presentation.response;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funding_amountInfoResponse {

    private Long funding_amount_id;
    private Double current_amount;
    private Integer backers_count;
    private Double progress;

    public static Funding_amountInfoResponse fromOneFunding_amount (Funding_amount funding_amount){
        return Funding_amountInfoResponse.builder()
                .funding_amount_id(funding_amount.getFunding_amount_id())
                .current_amount(funding_amount.getCurrent_amount())
                .backers_count(funding_amount.getBackers_count())
                .progress(funding_amount.getProgress())
                .build();
    }
}
