package tef.smarth.model;

import lombok.*;
import tef.smarth.entity.enums.BloodGroup;
import tef.smarth.entity.enums.Sex;

import java.sql.Date;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Sex sex;

    private Date birthday;

    private int weight;

    private int height;

    private String email;

    private BloodGroup bloodGroup;

    private int hip;

    private int waist;

}