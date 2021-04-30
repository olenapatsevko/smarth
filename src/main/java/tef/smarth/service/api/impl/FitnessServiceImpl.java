package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.fitness.FitnessClient;
import tef.smarth.api.fitness.request.FitnessRequest;
import tef.smarth.api.fitness.response.FitnessResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.Sex;
import tef.smarth.model.Fitness;
import tef.smarth.service.RecordService;
import tef.smarth.service.api.FitnessService;

import static tef.smarth.utils.DateUtil.calculateAge;

@Service
public class FitnessServiceImpl implements FitnessService {

    @Autowired
    private FitnessClient fitnessClient;

    @Autowired
    private RecordService recordService;

    public FitnessResponse getFitnessPlan(UserEntity userEntity, Fitness fitness) {
        return fitnessClient.post(FitnessRequest.builder()
                .age(String.valueOf(calculateAge(userEntity.getBirthday().toLocalDate())))
                .deficit(String.valueOf(fitness.getDeficit()))
                .exercise(fitness.getExercise())
                .gender(userEntity.getSex().equals(Sex.MALE) ? "male" : "female")
                .goalWeight(String.valueOf(fitness.getGoalWeight()))
                .height(recordService.getBMIHeight(userEntity))
                .hip(recordService.getBMIHip(userEntity))
                .neck(String.valueOf(fitness.getNeck()))
                .waist(recordService.getBMIWaist(userEntity))
                .goal(fitness.getGoal())
                .weight(recordService.getBMIWeight(userEntity))
                .build());
    }
}
