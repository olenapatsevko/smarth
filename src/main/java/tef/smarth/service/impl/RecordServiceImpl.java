package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;
import tef.smarth.model.AddDataModel;
import tef.smarth.repository.RecordRepository;
import tef.smarth.service.RecordService;
import tef.smarth.service.UserService;

import java.sql.Date;
import java.util.Objects;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private UserService userService;

    @Override
    public void saveRecords(AddDataModel addDataModel) {
        saveDouble(addDataModel.getHip(), ParameterType.HIP, "hip", addDataModel.getDate());
        saveDouble(addDataModel.getWaist(), ParameterType.WAIST, "waist", addDataModel.getDate());
        saveDouble(addDataModel.getWeight(), ParameterType.WEIGHT, "weight", addDataModel.getDate());
        saveDouble(addDataModel.getHeight(), ParameterType.HEIGHT, "height", addDataModel.getDate());
        saveDouble(addDataModel.getGlucoseBlood(), ParameterType.GLUCOSE_BLOOD, "glucoseBlood", addDataModel.getDate());
        saveDouble(addDataModel.getGlucoseUrine(), ParameterType.GLUCOSE_URINE, "glucoseUrine", addDataModel.getDate());
        saveDouble(addDataModel.getUrea(), ParameterType.UREA, "urea", addDataModel.getDate());
        saveDouble(addDataModel.getCreatinine(), ParameterType.CREATININE, "creatinine", addDataModel.getDate());
        saveDouble(addDataModel.getUricAcid(), ParameterType.URIC_ACID, "uricAcid", addDataModel.getDate());
        saveDouble(addDataModel.getTotalProteins(), ParameterType.TOTAL_PROTEINS, "totalProteins", addDataModel.getDate());
        saveDouble(addDataModel.getTotalBilirubin(), ParameterType.TOTAL_BILIRUBIN, "totalBilirubin", addDataModel.getDate());
        saveDouble(addDataModel.getDirectBilirubin(), ParameterType.DIRECT_BILIRUBIN, "directBilirubin", addDataModel.getDate());
        saveDouble(addDataModel.getCholesterol(), ParameterType.CHOLESTEROL, "cholesterol", addDataModel.getDate());
        saveDouble(addDataModel.getHDL(), ParameterType.HDL, "HDL", addDataModel.getDate());
        saveDouble(addDataModel.getLDL(), ParameterType.LDL, "LDL", addDataModel.getDate());
        saveDouble(addDataModel.getGDH(), ParameterType.GDH, "GDH", addDataModel.getDate());
        saveDouble(addDataModel.getGGT(), ParameterType.GGT, "GGT", addDataModel.getDate());
        saveDouble(addDataModel.getLDH(), ParameterType.LDH, "LDH", addDataModel.getDate());
        saveDouble(addDataModel.getCRP(), ParameterType.CRP, "CRP", addDataModel.getDate());
        saveDouble(addDataModel.getAlkalinePhosphatase(), ParameterType.ALKALINE_PHOSPHATASE, "alkalinePhosphatase,", addDataModel.getDate());
        saveDouble(addDataModel.getALT(), ParameterType.AST, "ALT", addDataModel.getDate());
        saveDouble(addDataModel.getAST(), ParameterType.AST, "AST", addDataModel.getDate());
        saveDouble(addDataModel.getAmylase(), ParameterType.AMYLASE, "amylase", addDataModel.getDate());
        saveDouble(addDataModel.getAlbumin(), ParameterType.ALBUMIN, "albumin", addDataModel.getDate());
        saveDouble(addDataModel.getGlobulin(), ParameterType.GLOBULIN, "globulin", addDataModel.getDate());
        saveDouble(addDataModel.getPH(), ParameterType.P_H, "pH", addDataModel.getDate());
        saveDouble(addDataModel.getProtein(), ParameterType.PROTEIN, "protein", addDataModel.getDate());
        saveDouble(addDataModel.getDensity(), ParameterType.DENSITY, "density", addDataModel.getDate());
        saveDouble(addDataModel.getKetoneBodies(), ParameterType.KETONE_BODIES, "ketoneBodies", addDataModel.getDate());
        saveDouble(addDataModel.getBilirubin(), ParameterType.BILIRUBIN, "bilirubin", addDataModel.getDate());
        saveDouble(addDataModel.getUrobilinogen(), ParameterType.UROBILINOGEN, "urobilinogen", addDataModel.getDate());
        saveDouble(addDataModel.getHaemoglobin(), ParameterType.HEMOGLOBIN, "haemoglobin", addDataModel.getDate());
        saveDouble(addDataModel.getErythrocytes(), ParameterType.ERYTHROCYTES, "erythrocytes", addDataModel.getDate());
        saveDouble(addDataModel.getLeukocytes(), ParameterType.LEUKOCYTES, "leukocytes", addDataModel.getDate());
        saveDouble(addDataModel.getEpithelialCells(), ParameterType.EPITHELIAL_CELLS, "epithelialCells", addDataModel.getDate());
    }

    void saveDouble(Double value, ParameterType parameterType, String name, Date date) {
        if(Objects.nonNull(value)) {
            recordRepository.save(RecordEntity.builder()
                    .recordType(RecordType.DOUBLE)
                    .parameterType(parameterType)
                    .value(String.valueOf(value))
                    .user(userService.obtainCurrentPrincipleUser())
                    .name(name)
                    .date(date)
                    .build());
        }
    }
}
