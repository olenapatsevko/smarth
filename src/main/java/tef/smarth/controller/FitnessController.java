package tef.smarth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.fitness.request.Exercise;
import tef.smarth.api.fitness.FitnessClient;
import tef.smarth.api.fitness.request.FitnessRequest;
import tef.smarth.api.fitness.request.Goal;


@RestController
@RequestMapping("/api")
public class FitnessController {
    @Autowired
    private FitnessClient fitnessClient;

    @GetMapping(value = "/fitness", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object postBMI(Model model) {
        return
                fitnessClient.post(FitnessRequest.builder()
                        .age("30")
                        .deficit("500")
                        .exercise(Exercise.LITTLE)
                        .gender("male")
                        .goalWeight("85")
                        .height("190")
                        .hip("100")
                        .neck("41")
                        .waist("88")
                        .goal(Goal.MAINTENANCE)
                        .weight("80")
                        .build());
    }
}
