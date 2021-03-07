package tef.smarth.service;


import tef.smarth.entity.RoleEntity;
import tef.smarth.entity.UserEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> findAll();

    RoleEntity findById(Integer id);

    RoleEntity save(RoleEntity role);

    List<RoleEntity> findAllByUser(UserEntity userEntity);

}