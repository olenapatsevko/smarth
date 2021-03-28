package tef.smarth.controller.mobile.mapper;


import tef.smarth.entity.UserEntity;
import tef.smarth.model.UserDto;

public final class UserMapper {

    private UserMapper() {
        //to prevent creating default public constr.
    }

    public static UserDto toDto(UserEntity user) {
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setId(user.getId());
//        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        //todo set all needed fields

        return dto;
    }

}
