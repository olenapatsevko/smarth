package tef.smarth.api.bmi.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonSerialize
public class BMIResponse implements Serializable {
    private Weight weight;

    private Height height;

    private Bmi bmi;

    private String ideal_weight;

    private String surface_area;

    private String ponderal_index;

    private Bmr bmr;

    private Whr whr;

    public Whtr whtr;

}
