package tef.smarth.service;

import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.model.AddDataModel;
import tef.smarth.model.Record;

public interface RecordService {

   void saveRecords(AddDataModel addDataModel);
    String getBMIHip(UserEntity userEntity);
   String getBMIWaist(UserEntity userEntity);
   String getBMIHeight(UserEntity userEntity);
   String getBMIWeight(UserEntity userEntity);

    Record getLatestRecord(ParameterType parameterType, UserEntity userEntity);
}
