package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.bmi.BMIClient;
import tef.smarth.api.bmi.request.BMIParameter;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.Sex;
import tef.smarth.repository.RecordRepository;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.RecordService;
import tef.smarth.service.api.BMIService;
import tef.smarth.utils.DateUtil;

import static java.lang.String.valueOf;

@Service
public class BMIServiceImpl implements BMIService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BMIClient bmiClient;

    @Autowired
    private RecordService recordService;


    @Override
    public BMIResponse getBMI(UserEntity userEntity1) {
        UserEntity userEntity = userRepository.findByUsername(userEntity1.getUsername());

        return bmiClient.post(BMIRequest.builder()
                .age(valueOf(DateUtil.calculateAge(userEntity.getBirthday().toLocalDate())))
                .height(BMIParameter.builder()
                        .value(recordService.getBMIHeight(userEntity))
                        .unit("cm")
                        .build())
                .sex(userEntity.getSex().equals(Sex.MALE) ? "m" : "f")
                .weight(BMIParameter.builder()
                        .value(recordService.getBMIWeight(userEntity))
                        .unit("kg")
                        .build())
                .hip(recordService.getBMIHip(userEntity))
                .waist(recordService.getBMIWaist(userEntity))
                .build(), userEntity);
    }
}
