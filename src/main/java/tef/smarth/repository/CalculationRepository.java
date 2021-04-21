package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.CalculationEntity;

@Repository
public interface CalculationRepository extends CrudRepository<CalculationEntity, Integer> {
}
