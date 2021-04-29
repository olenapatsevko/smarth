package tef.smarth.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tef.smarth.model.AddDataModel;
import tef.smarth.service.UserService;

import java.util.function.DoublePredicate;

import static tef.smarth.utils.DateUtil.getCurrentSqlDate;


@Component
public class RecordValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AddDataModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        var addDataModel = (AddDataModel) o;
        if (addDataModel.getDate() != null) {
            if (addDataModel.getDate().before(userService.obtainCurrentPrincipleUser().getBirthday()) || addDataModel.getDate().after(getCurrentSqlDate())) {
                errors.rejectValue("date", "date.not.valid");
            }
        }
        DoublePredicate doublePredicate = x -> x < 0. || x > 100.;

        checkField(doublePredicate, "hip", "validation.hip", addDataModel.getHip(), errors);
        checkField(doublePredicate, "waist", "validation.waist", addDataModel.getWaist(), errors);
        checkField(doublePredicate, "weight", "validation.weight", addDataModel.getWeight(), errors);
        checkField(doublePredicate, "height", "validation.height", addDataModel.getHeight(), errors);
        checkField(doublePredicate, "glucoseBlood", "validation.glucoseBlood", addDataModel.getGlucoseBlood(), errors);
        checkField(doublePredicate, "glucoseUrine", "validation.glucoseUrine", addDataModel.getGlucoseUrine(), errors);
        checkField(doublePredicate, "urea", "validation.urea", addDataModel.getUrea(), errors);
        checkField(doublePredicate, "creatinine", "validation.creatinine", addDataModel.getCreatinine(), errors);
        checkField(doublePredicate, "uricAcid", "validation.uricAcid", addDataModel.getUricAcid(), errors);
        checkField(doublePredicate, "totalProteins", "validation.totalProteins", addDataModel.getTotalProteins(), errors);
        checkField(doublePredicate, "totalBilirubin", "validation.totalBilirubin", addDataModel.getTotalBilirubin(), errors);
        checkField(doublePredicate, "directBilirubin", "validation.directBilirubin", addDataModel.getDirectBilirubin(), errors);
        checkField(doublePredicate, "cholesterol", "validation.cholesterol", addDataModel.getCholesterol(), errors);
        checkField(doublePredicate, "HDL", "validation.HDL", addDataModel.getHDL(), errors);
        checkField(doublePredicate, "LDL", "validation.LDL", addDataModel.getLDL(), errors);
        checkField(doublePredicate, "GDH", "validation.GDH", addDataModel.getGDH(), errors);
        checkField(doublePredicate, "GGT", "validation.GGT", addDataModel.getGGT(), errors);
        checkField(doublePredicate, "LDH", "validation.LDH", addDataModel.getLDH(), errors);
        checkField(doublePredicate, "CRP", "validation.CRP", addDataModel.getCRP(), errors);
        checkField(doublePredicate, "alkalinePhosphatase", "validation.alkalinePhosphatase;", addDataModel.getAlkalinePhosphatase(), errors);
        checkField(doublePredicate, "ALT", "validation.ALT", addDataModel.getALT(), errors);
        checkField(doublePredicate, "AST", "validation.AST", addDataModel.getAST(), errors);
        checkField(doublePredicate, "amylase", "validation.amylase", addDataModel.getAmylase(), errors);
        checkField(doublePredicate, "albumin", "validation.albumin", addDataModel.getAlbumin(), errors);
        checkField(doublePredicate, "globulin", "validation.globulin", addDataModel.getGlobulin(), errors);
        checkField(doublePredicate, "pH", "validation.pH", addDataModel.getPH(), errors);
        checkField(doublePredicate, "protein", "validation.protein", addDataModel.getProtein(), errors);
        checkField(doublePredicate, "density", "validation.density", addDataModel.getDensity(), errors);
        checkField(doublePredicate, "ketoneBodies", "validation.ketoneBodies", addDataModel.getKetoneBodies(), errors);
        checkField(doublePredicate, "bilirubin", "validation.bilirubin", addDataModel.getBilirubin(), errors);
        checkField(doublePredicate, "urobilinogen", "validation.urobilinogen", addDataModel.getUrobilinogen(), errors);
        checkField(doublePredicate, "haemoglobin", "validation.haemoglobin", addDataModel.getHaemoglobin(), errors);
        checkField(doublePredicate, "erythrocytes", "validation.erythrocytes", addDataModel.getErythrocytes(), errors);
        checkField(doublePredicate, "leukocytes", "validation.leukocytes", addDataModel.getLeukocytes(), errors);
        checkField(doublePredicate, "epithelialCells", "validation.epithelialCells", addDataModel.getEpithelialCells(), errors);
    }

    public void checkField(DoublePredicate predicate, String s, String s1, Double o, Errors errors) {
        if (o != null && predicate.test(o)) {
            errors.rejectValue(s, s1);
        }

    }
}
