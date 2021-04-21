package tef.smarth.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mapping<User,UserEntity> {
}
