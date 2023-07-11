package team1.funddigging.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFundingRequest {

    private Double goal_amount;

    private String created_date;

    private String title;

    private String description;

    private Double price;

    private String start_date;

    private String end_date;

    private String image;

    private String funding_title;

}
