package userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserDTO {
    // Getter 和 Setter
    private Long userId;
    private String email;
    private String password;
}