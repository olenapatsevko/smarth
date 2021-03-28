package tef.smarth.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistrationResponse {

    boolean registrationSuccess;
    String error;
}
