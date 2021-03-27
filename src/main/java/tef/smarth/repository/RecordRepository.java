package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import tef.smarth.entity.RecordEntity;

public interface RecordRepository extends CrudRepository<RecordEntity, Integer>  {
}
