package tef.smarth.entity.enums;

public enum ParameterType {
    MASS_INDEX,
    LEUKOCYTES,
    HEMOGLOBIN,
    HEMOPROTEIN,
    THROMBOCYTES,
    HOMA,
    AST("Aspartate transaminase (AST)"),
    ALT("Alanine transaminase (ALT)");

    private String value;

    ParameterType(String value) {
        this.value = value;
    }

    ParameterType() {
    }
}
