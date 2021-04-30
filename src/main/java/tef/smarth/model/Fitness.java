package tef.smarth.model;

import lombok.*;
import tef.smarth.api.fitness.request.Exercise;
import tef.smarth.api.fitness.request.Goal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fitness {
    private Double deficit;
    private Exercise exercise;
    private Double goalWeight;
    private Double neck;
    private Goal goal;


}
