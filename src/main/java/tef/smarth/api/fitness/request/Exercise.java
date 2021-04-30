package tef.smarth.api.fitness.request;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Exercise {
    LITTLE("little"),
    LIGHT("light"),
    MODERATE("moderate"),
    HEAVY("heavy"),
    VERYHEAVY("veryheavy");

    public String name;

    Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}