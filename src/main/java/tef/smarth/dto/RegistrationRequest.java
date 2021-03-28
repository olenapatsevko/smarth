package tef.smarth.dto;

import lombok.Data;
import tef.smarth.entity.enums.BloodGroup;

import java.sql.Date;

@Data
public class RegistrationRequest {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private boolean isMan;

    private Date birthday;

    private int weight;

    private int height;

    private String email;

    private BloodGroup bloodGroup;
}
