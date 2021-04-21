package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.DiseaseEntity;

@Repository
public interface DiseaseRepository extends CrudRepository<DiseaseEntity, Integer> {
}
