package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.RoleEntity;
import tef.smarth.entity.UserEntity;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    List<RoleEntity> findAllByUsers(UserEntity userEntity);
}
