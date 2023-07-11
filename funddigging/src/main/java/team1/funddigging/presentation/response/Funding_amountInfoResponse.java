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

    private Double current_amount;
    private Integer backers_count;

    public static Funding_amountInfoResponse fromOneFunding_amount (Funding_amount funding_amount){
        return Funding_amountInfoResponse.builder()
                .current_amount(funding_amount.getCurrent_amount())
                .backers_count(funding_amount.getBackers_count())
                .build();
    }
}
