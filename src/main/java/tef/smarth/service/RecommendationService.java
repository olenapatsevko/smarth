package tef.smarth.service;

import org.springframework.stereotype.Service;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.model.Recommendation;

import java.util.List;

@Service
public interface RecommendationService {
    RecommendationResponse getMobileRecommendations(int count);

    List<Recommendation> getRecommendations(int count);
}
