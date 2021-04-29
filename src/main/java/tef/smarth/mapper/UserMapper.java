package tef.smarth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper  {
    UserEntity convertToEntity (User model);

    User convertToModel(UserEntity entity);
}
