package tef.smarth.model;

import lombok.*;
import tef.smarth.entity.enums.BloodGroup;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


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

    private boolean isMan;

    private Date birthday;

    private int weight;

    private int height;

    private String email;

    private BloodGroup bloodGroup;

    private Set<Disease> diseases;

    private Set<Record> records;

    private int hip;

    private int waist;

    private Set<Calculation> calculations;

    private Set<Role> roles = new HashSet<>();
}