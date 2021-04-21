package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.RecommendationEntity;
import tef.smarth.model.Recommendation;

@Mapper(componentModel = "spring")
public interface RecommendationMapper extends Mapping<Recommendation, RecommendationEntity>{
}
