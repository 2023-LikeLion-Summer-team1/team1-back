package team1.funddigging.presentation.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.dto.RoomDto;
import team1.funddigging.domain.entity.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomInfoResponse {


    private Long room_id;
    //private User host_user_id;
    //private Category category_id;
    private String host_name;
    private String host_email;
    private String room_name;
    private String description;
    private String room_image;
    private String title_image;
    private Integer follower;
    private String category_name;

    public static RoomInfoResponse fromOneRoom (Room room){
        return RoomInfoResponse.builder()
                .room_id(room.getRoom_id())
                .host_name(room.getHost_name())
                .host_email(room.getHost_email())
                .room_name(room.getRoom_name())
                .description(room.getDescription())
                .room_image(room.getRoom_image())
                .title_image(room.getTitle_image())
                .follower(room.getFollower())
                .category_name(room.getCategory_id().getName())
                .build();
    }

    public static RoomInfoResponse from (RoomDto roomDto){
        return RoomInfoResponse.builder()
                .room_id(roomDto.getRoom_id())
                .host_name(roomDto.getHost_name())
                .host_email(roomDto.getHost_email())
                .room_name(roomDto.getRoom_name())
                .description(roomDto.getDescription())
                .room_image(roomDto.getRoom_image())
                .title_image(roomDto.getTitle_image())
                .follower(roomDto.getFollower())
                .category_name(roomDto.getCategory_id().getName())
                .build();
    }
}
