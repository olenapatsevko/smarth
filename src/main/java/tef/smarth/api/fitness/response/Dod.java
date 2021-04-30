package tef.smarth.api.fitness.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dod{
    public String formulaName;
    public double value;
    public String conclusion;
    public List<String> unit;
    public Calories calories;
    public Joules joules;
}
