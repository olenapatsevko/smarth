package tef.smarth.entity.enums;

public enum CalculationType {

    RITIS("De Ritis Ratio"),
    LDH_AST("LDH/AST"),
    SCHMIDT("Schmidt coefficient"),
    GGT_AST("GGT/AST"),
    ALT_DGH("ATL/DGH"),
    AC("Atherogenic coefficient");

    public String name;

    public String getName() {
        return name;
    }

    CalculationType(String value) {
        this.name = value;
    }
}
