package tef.smarth.service;

import tef.smarth.entity.UserEntity;
import tef.smarth.model.AddDataModel;

public interface RecordService {

   void saveRecords(AddDataModel addDataModel);
    String getBMIHip(UserEntity userEntity);
   String getBMIWaist(UserEntity userEntity);
   String getBMIHeight(UserEntity userEntity);
   String getBMIWeight(UserEntity userEntity);
}
