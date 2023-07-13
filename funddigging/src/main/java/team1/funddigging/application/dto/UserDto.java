package team1.funddigging.application.dto;

import ...

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String accessToken;

    private Long kakaoId;

    private String refreshToken;

    private String email;

    private String nickName;

    private String sentence;

    public static UserDto toUserDto(String accessToken, String refreshToken, String email, String nickName, Long userKakaoId) {
        return UserDto.builder()
                .email(email)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .nickName(nickName)
                .kakaoId(userKakaoId)
                .build();
    }

    public static UserDto toUserDto(UserUpdateRequest userUpdateRequest) {
        return UserDto.builder()
                .email(userUpdateRequest.getEmail())
                .nickName(userUpdateRequest.getNickName())
                .sentence(userUpdateRequest.getSentence())
                .build();
    }
}