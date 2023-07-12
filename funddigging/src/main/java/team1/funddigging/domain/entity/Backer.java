package team1.funddigging.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import team1.funddigging.application.dto.BackerDto;
import team1.funddigging.application.dto.FundingDto;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE backer SET deleted = true WHERE backer_id = ?")
public class Backer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backer_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Funding funding_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;

    private Double contribution_amount;

    private Integer fund_num;

    public static Backer toBacker(BackerDto dto, Funding funding,  User user) {

        return Backer.builder()
                .funding_id(funding)
                .user_id(user)
                .contribution_amount(dto.getContribution_amount())
                .fund_num(dto.getFund_num())
                .build();


    }

}
