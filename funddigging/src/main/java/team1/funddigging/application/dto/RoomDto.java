package team1.funddigging.application.dto;


import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.Member;
//import team1.funddigging.presentation.request.ChangeRoomInfoRequest;
import lombok.*;
import team1.funddigging.presentation.request.AddRoomRequest;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {

    private Long room_id;

    private Member host_user_id;

    private Category category_id;

    private String host_name;

    private String host_email;

    private String room_name;

    private String description;

    private String room_image;

    private String title_image;

    private Integer follower;

    private List<Funding> fundingList = new ArrayList<>();

    public static RoomDto from(Room room) {
        return RoomDto.builder()
                .room_id(room.getRoom_id())
                .host_user_id(room.getHost_user_id())
                .category_id(room.getCategory_id())
                .host_name(room.getHost_name())
                .host_email(room.getHost_email())
                .room_name(room.getRoom_name())
                .description(room.getDescription())
                .room_image(room.getRoom_image())
                .title_image(room.getTitle_image())
                .follower(room.getFollower())
                .build();
    }

    public static RoomDto toAdd(AddRoomRequest request) {
        return RoomDto.builder()
                .host_name(request.getHost_name())
                .host_email(request.getHost_email())
                .room_name(request.getRoom_name())
                .description(request.getDescription())
                .room_image(request.getRoom_image())
                .title_image(request.getTitle_image())
                .follower(0)
                .build();
    }

}
