package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.entity.CalculationEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.CalculationType;
import tef.smarth.entity.enums.Measurements;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.mapper.CalculationsMapper;
import tef.smarth.model.Calculation;
import tef.smarth.model.Record;
import tef.smarth.repository.CalculationRepository;
import tef.smarth.service.CalculationService;
import tef.smarth.service.RecordService;
import tef.smarth.service.SecurityService;

import java.util.ArrayList;
import java.util.List;

import static tef.smarth.utils.DateUtil.getCurrentSqlDate;
import static tef.smarth.utils.NumberUtils.round;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private CalculationRepository calculationRepository;

    @Autowired
    private CalculationsMapper calculationsMapper;

    @Autowired
    private RecordService recordService;

    @Autowired
    private SecurityService securityService;

    @Override
    public List<Calculation> getMedicalCalculations(UserEntity userEntity) {
        List<Calculation> calculations = new ArrayList<>();
        calculations.add(calculationsMapper.convertToModel(caluclateRitis(recordService.getLatestRecord(ParameterType.AST, userEntity), recordService.getLatestRecord(ParameterType.ALT, userEntity), userEntity)));
        calculations.add(calculationsMapper.convertToModel(caluclateLDGtoAST(recordService.getLatestRecord(ParameterType.LDH, userEntity), recordService.getLatestRecord(ParameterType.AST, userEntity), userEntity)));
        calculations.add(calculationsMapper.convertToModel(calculateSchmidt(recordService.getLatestRecord(ParameterType.AST, userEntity), recordService.getLatestRecord(ParameterType.ALT, userEntity), recordService.getLatestRecord(ParameterType.GDH, userEntity), userEntity)));
        calculations.add(calculationsMapper.convertToModel(caluclateGGTPtoAST(recordService.getLatestRecord(ParameterType.GGT, userEntity), recordService.getLatestRecord(ParameterType.AST, userEntity), userEntity)));
        calculations.add(calculationsMapper.convertToModel(calculateKA(recordService.getLatestRecord(ParameterType.LDL, userEntity), recordService.getLatestRecord(ParameterType.HDL, userEntity), recordService.getLatestRecord(ParameterType.VLDL, userEntity), userEntity)));
        return calculations;
    }


    @Override
    public CalculationEntity caluclateRitis(Record ast, Record alt, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.RITIS)
                        .value(round(Double.parseDouble(ast.getValue()) / Double.parseDouble(alt.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("It is measured with a blood test and is sometimes useful in medical diagnosis to differentiate between causes of liver damage, or hepatotoxicity.")
                        .build());
    }

    @Override
    public CalculationEntity caluclateLDGtoAST(Record ldh, Record ast, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.LDH_AST)
                        .value(round(Double.parseDouble(ldh.getValue()) / Double.parseDouble(ast.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("It is sometimes useful to differentiate between causes of icterus")
                        .build());
    }

    @Override
    public CalculationEntity caluclateALTtoGLDG(Record alt, Record gldg, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.ALT_DGH)
                        .value(round(Double.parseDouble(alt.getValue()) / Double.parseDouble(gldg.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("It is sometimes useful to differentiate between causes of icterus.")
                        .build());
    }

    @Override
    public CalculationEntity caluclateGGTPtoAST(Record ggt, Record ast, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.GGT_AST)
                        .value(round(Double.parseDouble(ggt.getValue()) / Double.parseDouble(ast.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("Use of levels of these enzymes allows to differentiate liver diseases")
                        .build());
    }

    @Override
    public CalculationEntity calculateKA(Record ldl, Record hdl, Record vldl, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.AC)
                        .value(round(Double.parseDouble(ldl.getValue()) + Double.parseDouble(vldl.getValue()) / Double.parseDouble(hdl.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("It is sometimes useful to differentiate between causes of icterus")
                        .build());
    }

    @Override
    public CalculationEntity calculateSchmidt(Record ast, Record alt, Record gdh, UserEntity userEntity) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(userEntity)
                        .name(CalculationType.SCHMIDT)
                        .value(round((Double.parseDouble(ast.getValue()) + Double.parseDouble(alt.getValue())) / Double.parseDouble(gdh.getValue()),2))
                        .measurement(Measurements.NONE)
                        .meaning("Use of levels of these enzymes allows to differentiate heart, liver diseases and also causes of icterus")
                        .build());
    }
}
