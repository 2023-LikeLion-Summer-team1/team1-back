package team1.funddigging.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.User;
import team1.funddigging.domain.repository.CategoryRepository;
import team1.funddigging.presentation.request.AddBackerRequest;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackerDto {


    private Long backer_id;

    private Funding funding_id;

    private User seller_user_id;

    private Double contribution_amount;

    private Integer fund_num;

    public static BackerDto toAdd(AddBackerRequest request) {
        return BackerDto.builder()
                .fund_num(request.getFund_num())
                .build();
    }
}
