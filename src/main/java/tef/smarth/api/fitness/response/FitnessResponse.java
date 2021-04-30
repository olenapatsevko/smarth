package tef.smarth.api.fitness.response;

import lombok.*;



@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FitnessResponse {
    public String height;
    public String weight;
    public String age;
    public String gender;
    public String neck;
    public String hip;
    public String waist;
    public String deficit;
    public String goalWeight;
    public BodyMassIndex bodyMassIndex;
    public BodyFatPercentage bodyFatPercentage;
    public LeanBodyMass leanBodyMass;
    public RestingDailyEnergyExpenditure restingDailyEnergyExpenditure;
    public BasalMetabolicRate basalMetabolicRate;
    public TotalDailyEnergyExpenditure totalDailyEnergyExpenditure;
    public IdealBodyWeight idealBodyWeight;
    public TimeBeforeGoalWeight timeBeforeGoalWeight;
    public WaistToHipRatio waistToHipRatio;
}
