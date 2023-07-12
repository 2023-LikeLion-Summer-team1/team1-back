package team1.funddigging.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRoomRequest {

    private String host_name;

    private String host_email;

    private String room_name;

    private String description;

    private String room_image;

    private String title_image;

}
