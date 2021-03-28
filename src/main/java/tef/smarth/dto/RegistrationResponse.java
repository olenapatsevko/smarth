package tef.smarth.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistrationResponse {

    String email;
    String username;
    String password;
    String error;
}
