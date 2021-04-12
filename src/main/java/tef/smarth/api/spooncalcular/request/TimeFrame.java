package tef.smarth.api.spooncalcular.request;

public enum  TimeFrame {
    DAY("day"),
    WEEK("week");

    String code;
    TimeFrame(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
