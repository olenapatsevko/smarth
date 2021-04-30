package tef.smarth.api.fitness.request;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Goal {
    MODERATE_FAT_LOSS("moderate fat loss"),
    AGGRESSIVE_FAT_LOSS("aggressive fat loss"),
    RECKLESS_FAT_LOSS("reckless fat loss"),
    MAINTENANCE("maintenance"),
    SLOW_BULKING("slow bulking"),
    NORMAL_BULKING("normal bulking"),
    AGGRESSIVE_BULKING("aggressive bulking");

    public String getValue() {
        return value;
    }

    public String value;

    Goal(String name) {
        this.value = name;
    }
}
