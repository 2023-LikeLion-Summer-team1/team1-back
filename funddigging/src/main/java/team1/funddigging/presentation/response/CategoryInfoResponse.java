package team1.funddigging.presentation.response;

import team1.funddigging.application.dto.CategoryDto;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.Funding;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryInfoResponse {


    private Long category_id;
    private String name;

    public static CategoryInfoResponse from(CategoryDto categoryDto) {
        return CategoryInfoResponse.builder()
                .category_id(categoryDto.getCategory_id())
                .name(categoryDto.getName())
                .build();
    }



}
