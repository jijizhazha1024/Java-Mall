package userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserDTO {
    // Getter 和 Setter
    private String email;
    private String password;
    private String confirmPassword;
}

