package team1.funddigging.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import team1.funddigging.application.dto.FundingDto;
//import com.likelion.backend.domain.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import team1.funddigging.application.dto.Funding_amountDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE funding_amount SET deleted = true WHERE funding_amount_id = ?")
public class Funding_amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funding_amount_id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Funding funding_id;

    private Double current_amount;

    private Integer backers_count;

    private Double progress;


    public static Funding_amount toFunding(Funding_amountDto dto) {



        return Funding_amount.builder()
                .funding_id(dto.getFunding_id())
                .current_amount(dto.getCurrent_amount())
                .backers_count(dto.getBackers_count())
                .progress(dto.getProgress())
                .build();


    }
}
