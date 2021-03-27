package tef.smarth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tef.smarth.entity.RecommendationEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResponse {
    List<RecommendationEntity> recommendations;
}
