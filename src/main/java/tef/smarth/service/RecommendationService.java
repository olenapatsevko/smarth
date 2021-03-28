package tef.smarth.service;

import org.springframework.stereotype.Service;
import tef.smarth.dto.RecommendationResponse;

@Service
public interface RecommendationService {
    RecommendationResponse getRecommendations(int count);
}
