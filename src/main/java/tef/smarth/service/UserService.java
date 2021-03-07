package tef.smarth.service;

import tef.smarth.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();

    UserEntity findById(Integer id);

    UserEntity save(UserEntity userEntity);

    UserEntity findByUsername(String username);

    void registerUser(UserEntity user);

}