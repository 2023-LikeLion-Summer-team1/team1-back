package team1.funddigging.presentation.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.User;

import java.time.LocalDateTime;

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

}
