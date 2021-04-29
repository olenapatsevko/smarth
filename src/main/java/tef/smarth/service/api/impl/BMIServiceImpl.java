package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.repository.RecordRepository;
import tef.smarth.service.api.BMIService;

@Service
public class BMIServiceImpl implements BMIService {

    @Autowired
    private RecordRepository recordRepository;


    @Override
    public BMIResponse getBMI(UserEntity userEntity) {
        return null;
    }

    private String getBMIHip(UserEntity userEntity){
      return recordRepository.findAnyByParameterTypeAndUser(ParameterType.HIP, userEntity).getValue();
    }
    private String getBMIWaist(){
        return "";
    }

    private String getBMIHeight(){
        return "";
    }

    private String getBMIWeight(){
        return "";
    }



}
