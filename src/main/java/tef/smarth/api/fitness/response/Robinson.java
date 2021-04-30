package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Robinson{
    public String formulaName;
    public Metric metric;
    public Imperial imperial;
}
