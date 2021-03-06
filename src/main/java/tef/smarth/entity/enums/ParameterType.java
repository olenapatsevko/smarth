package tef.smarth.entity.enums;

public enum ParameterType {
    MASS_INDEX("Body mass index"),
    LEUKOCYTES(),
    HEMOGLOBIN(),
    HEMOPROTEIN(),
    THROMBOCYTES(),
    HOMA(),
    AST("Aspartate transaminase (AST)"),
    ALT("Alanine transaminase (ALT)"),
    HIP,
    WAIST,
    WEIGHT,
    HEIGHT,
    GLUCOSE_BLOOD,
    GLUCOSE_URINE,
    UREA,
    CREATININE,
    URIC_ACID,
    TOTAL_PROTEINS,
    TOTAL_BILIRUBIN,
    DIRECT_BILIRUBIN,
    CHOLESTEROL,
    HDL,
    LDL,
    GDH,
    GGT,
    LDH,
    CRP,
    ALKALINE_PHOSPHATASE,
    AMYLASE,
    ALBUMIN,
    GLOBULIN,
    P_H,
    PROTEIN,
    DENSITY,
    KETONE_BODIES,
    BILIRUBIN,
    UROBILINOGEN,
    HAEMOGLOBIN,
    ERYTHROCYTES,
    EPITHELIAL_CELLS,
    VLDL;

    private String value;

    public String getValue() {
        return value;
    }

    ParameterType(String value) {
        this.value = value;
    }

    ParameterType() {
    }
}
