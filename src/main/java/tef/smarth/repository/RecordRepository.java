package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<RecordEntity, Integer> {

    List<RecordEntity> findAllByUserId(Integer id);

    RecordEntity findAnyByParameterTypeAndUser(ParameterType parameterType, UserEntity userEntity);
}
