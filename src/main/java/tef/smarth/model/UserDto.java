package tef.smarth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tef.smarth.entity.Calculation;
import tef.smarth.entity.Disease;
import tef.smarth.entity.Record;
import tef.smarth.entity.enums.BloodGroup;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isMan;
    private int age;
    private int weight;
    private int height;
    private String email;
    private BloodGroup bloodGroup;
    private Set<Disease> diseases;
    private Set<Record> records;
    private Set<Calculation> calculations;
    private String passwordConfirm;
}
