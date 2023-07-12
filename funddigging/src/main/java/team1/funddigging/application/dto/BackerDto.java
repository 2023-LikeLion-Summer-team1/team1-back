package team1.funddigging.application.dto;

import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Member;
import team1.funddigging.presentation.request.AddBackerRequest;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackerDto {


    private Long backer_id;

    private Funding funding_id;

    private Member seller_user_id;

    private Double contribution_amount;

    private Integer fund_num;

    public static BackerDto toAdd(AddBackerRequest request) {
        return BackerDto.builder()
                .fund_num(request.getFund_num())
                .build();
    }
}
