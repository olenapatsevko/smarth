package tef.smarth.service.api;

import tef.smarth.api.fitness.response.FitnessResponse;
import tef.smarth.entity.UserEntity;

public interface FitnessService {

    FitnessResponse getFitnessPlan(UserEntity userEntity);
}
