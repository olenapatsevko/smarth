package tef.smarth.service.api;

import tef.smarth.api.fitness.response.FitnessResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.Fitness;

public interface FitnessService {

    FitnessResponse getFitnessPlan(UserEntity userEntity, Fitness fitness);
}
