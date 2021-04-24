package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.RecommendationEntity;
import tef.smarth.entity.RecordEntity;
import tef.smarth.model.Recommendation;
import tef.smarth.model.Record;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationEntity convertToEntity (Recommendation model);

    Recommendation convertToModel(RecommendationEntity entity);
}
