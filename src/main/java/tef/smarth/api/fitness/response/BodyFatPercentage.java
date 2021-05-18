package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BodyFatPercentage{

    public Bmi bmi;
    public Dod dod;
    public Ymca ymca;
}
