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

    /*
    "funding_title" : String
	"title_image" : String
    "goal_amount" : Double
    "price" : 12000, Double
    description;
	"funding_image" : String,
	"funding_budget" : String,
	"funding_schedule" : String,
	"team_introduction" : String,
	"created_date" : String,
    "start_date" : String,
    "end_date" : String,
    "image" : String
     */

    //private Long category_id;

    private String funding_title;

    private String title_image;

    private Double goal_amount;

    private Double price;

    private String description;

    private String funding_image;

    private String funding_budget;

    private String funding_schedule;

    private String team_introduction;

    private String created_date;

    private String start_date;

    private String end_date;






}
