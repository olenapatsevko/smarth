package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.RecordEntity;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<RecordEntity, Integer> {

    List<RecordEntity> findAllByUserId(Integer id);
}
