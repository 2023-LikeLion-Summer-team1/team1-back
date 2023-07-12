package team1.funddigging.domain.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import com.likelion.backend.domain.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import team1.funddigging.application.dto.RoomDto;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE room SET deleted = true WHERE room_id = ?")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Member host_user_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category_id;

    private String host_name;

    private String host_email;

    private String room_name;

    private String description;

    private String room_image;

    private String title_image;

    private Integer follower;

    public static Room toRoom(RoomDto dto, Member user, Category category) {



        return Room.builder()
                .host_user_id(user)
                .category_id(category)
                .host_name(dto.getHost_name())
                .host_email(dto.getHost_email())
                .room_name(dto.getRoom_name())
                .description(dto.getDescription())
                .room_image(dto.getRoom_image())
                .title_image(dto.getTitle_image())
                .follower(dto.getFollower())
                .build();
    }


}
