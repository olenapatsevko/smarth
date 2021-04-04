package tef.smarth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.entity.Calculation;
import tef.smarth.entity.DiseaseEntity;
import tef.smarth.entity.RecommendationEntity;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.enums.BloodGroup;

import java.util.List;
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
    private Set<DiseaseEntity> diseases;
    private Set<RecordEntity> recordEntities;
    private Set<Calculation> calculations;
    private String passwordConfirm;
}
