package tef.smarth.controller.inner.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.service.impl.RecommendationServiceImpl;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    private RecommendationServiceImpl recommendationService;

    @GetMapping("/getRecommendations")
    public RecommendationResponse getRecommendations(){
       int  count = 5;
        return recommendationService.getMobileRecommendations(count);
    }
}
