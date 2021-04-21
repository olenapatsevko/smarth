package tef.smarth.entity.enums;

public enum Measurements {
    PERCENT ("%"),
    NONE("");

    private final String value;

    Measurements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Measurements of(String s){
        return  Measurements.valueOf(s);
    }


}
