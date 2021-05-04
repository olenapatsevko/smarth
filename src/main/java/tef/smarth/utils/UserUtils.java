package tef.smarth.utils;

import tef.smarth.dto.RegistrationRequest;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.Sex;

public class UserUtils {
    private UserUtils(){}

    public static UserEntity getUserEntity(RegistrationRequest request){
        return UserEntity.builder()
                .birthday(request.getBirthday())
                .bloodGroup(request.getBloodGroup())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .sex(Sex.MALE)
                .password(request.getPassword())
                .height(request.getHeight())
                .weight(request.getWeight())
                .hip(request.getHip())
                .waist(request.getWaist())
                .build();

    }
}
