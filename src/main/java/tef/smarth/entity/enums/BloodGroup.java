package tef.smarth.entity.enums;

public enum BloodGroup {

    O_P("O+"),
    A_P("A+"),
    B_P("B+"),
    AB_P("AB+"),
    O_N("O-"),
    A_N("A-"),
    B_N("B-"),
    AB_N("AB-");

    public String displayName;

    BloodGroup(String displayName){
        this.displayName = displayName;
    }
}
