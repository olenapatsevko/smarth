package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BodyMassIndex{
    public double value;
    public String conclusion;
    public String unit;
}
