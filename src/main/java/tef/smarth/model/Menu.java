package tef.smarth.model;

import lombok.*;
import tef.smarth.api.spooncalcular.request.DietType;
import tef.smarth.api.spooncalcular.request.TimeFrame;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    private DietType diet;
    private double targetCalories;
    private TimeFrame time;
}
