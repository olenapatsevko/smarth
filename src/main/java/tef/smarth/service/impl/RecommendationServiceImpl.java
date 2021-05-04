package tef.smarth.service.impl;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.entity.RecommendationEntity;
import tef.smarth.mapper.RecommendationMapper;
import tef.smarth.model.Recommendation;
import tef.smarth.repository.RecommendationsRepository;
import tef.smarth.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@Service
@Data
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationsRepository recommendationsRepository;

    @Autowired
    RecommendationMapper recommendationMapper;

    public RecommendationResponse getMobileRecommendations(int count) {
        return new RecommendationResponse(getRandomRecommendations(count));
    }

    public List<RecommendationEntity> getRandomRecommendations(int count) {
        var rand = new Random();
        List<RecommendationEntity> givenList = Lists.newArrayList(recommendationsRepository.findAll());
        List<RecommendationEntity> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            givenList.get(randomIndex).setId(i + 1);
            result.add(givenList.remove(randomIndex));
        }
        return result;
    }

    public List<Recommendation> getRecommendations(int count) {
        return getRandomRecommendations(count).stream()
                .map(recommendationMapper::convertToModel)
                .collect(toList());
    }
}
