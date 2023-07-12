package team1.funddigging.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.User;
import team1.funddigging.domain.repository.CategoryRepository;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funding_amountDto {

    private Long funding_amount_id;

    private Funding funding_id;

    private Double current_amount;

    private Integer backers_count;

    private Double progress;

    public static Funding_amountDto toFounding(Funding funding) {
        return Funding_amountDto.builder()
                .funding_id(funding)
                .current_amount(0D)
                .backers_count(0)
                .progress(0D)
                .build();
    }
}
