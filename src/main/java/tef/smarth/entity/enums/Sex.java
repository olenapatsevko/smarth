package tef.smarth.entity.enums;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

  public String displayName;

    Sex(String displayName){
        this.displayName = displayName;
    }
}
