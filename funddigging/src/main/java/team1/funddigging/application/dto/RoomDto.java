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
import team1.funddigging.presentation.request.AddRoomRequest;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {

    private Long Room_id;

    User host_user_id;

    Category category_id;

    private String host_name;

    private String host_email;

    private String room_name;

    private String description;

    private String room_image;

    private Integer follower;

    public static RoomDto toAdd(AddRoomRequest request) {
        return RoomDto.builder()
                .host_name(request.getHost_name())
                .host_email(request.getHost_email())
                .room_name(request.getRoom_name())
                .description(request.getDescription())
                .room_image(request.getRoom_image())
                .follower(0)
                .build();
    }

}
