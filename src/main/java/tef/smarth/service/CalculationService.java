package tef.smarth.service;

import org.springframework.stereotype.Service;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.Calculation;
import tef.smarth.model.MedicalCalculation;
import tef.smarth.model.Record;
import tef.smarth.entity.CalculationEntity;

import java.util.List;

@Service
public interface CalculationService {

    List<Calculation> getMedicalCalculations(UserEntity userEntity);

    CalculationEntity caluclateRitis(Record ast, Record alt, UserEntity userEntity);

    CalculationEntity caluclateLDGtoAST(Record ldg, Record ast, UserEntity userEntity);

    CalculationEntity caluclateALTtoGLDG (Record alt, Record gldg, UserEntity userEntity);

    CalculationEntity caluclateGGTPtoAST(Record ggtp, Record ast, UserEntity userEntity);

    CalculationEntity calculateKA(Record a, Record b, Record c, UserEntity userEntity);

    CalculationEntity calculateSchmidt(Record ast, Record alt, Record glht, UserEntity userEntity);
}
