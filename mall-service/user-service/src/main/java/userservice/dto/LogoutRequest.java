package userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutRequest {
    // Getter 和 Setter
    private Long userId;
    private String token;
}

