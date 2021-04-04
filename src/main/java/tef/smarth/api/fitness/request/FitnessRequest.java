package tef.smarth.api.fitness.request;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FitnessRequest {
    public String height;
    public String weight;
    public String age;
    public String gender;
    public Exercise exercise;
    public String neck;
    public String hip;
    public String waist;
    public Goal goal;
    public String deficit;
    public String goalWeight;
}
