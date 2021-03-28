package tef.smarth.service.impl;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.entity.RecommendationEntity;
import tef.smarth.repository.RecommendationsRepository;
import tef.smarth.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Data
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationsRepository recommendationsRepository;


    public RecommendationResponse getRecommendations(int count) {

        return new RecommendationResponse(getRandomRecommendations(count));

    }

    private List<RecommendationEntity> getRandomRecommendations(int count) {
        Random rand = new Random();
        List<RecommendationEntity> givenList = Lists.newArrayList(recommendationsRepository.findAll());
        List<RecommendationEntity> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            result.add(givenList.remove(randomIndex));
        }
        return result;
    }
}
