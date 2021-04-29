package tef.smarth.service.api;

import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.UserEntity;

public interface BMIService {

    BMIResponse getBMI(UserEntity userEntity);
}
