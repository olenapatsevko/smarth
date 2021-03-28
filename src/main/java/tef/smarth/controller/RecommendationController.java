package tef.smarth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tef.smarth.dto.RecommendationResponse;
import tef.smarth.service.impl.RecommendationServiceImpl;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    private RecommendationServiceImpl recommendationService;

    @GetMapping(value= "/getRecommendations/{count}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecommendationResponse getRecommendations(@PathVariable(name = "count") Integer count){
        return recommendationService.getRecommendations(count);
    }
}
