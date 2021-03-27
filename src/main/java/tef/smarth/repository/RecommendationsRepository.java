package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.RecommendationEntity;

@Repository
public interface RecommendationsRepository extends CrudRepository<RecommendationEntity, Integer> {
}
