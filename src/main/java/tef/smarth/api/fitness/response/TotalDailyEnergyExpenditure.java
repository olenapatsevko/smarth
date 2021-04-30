package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotalDailyEnergyExpenditure{
    public Bmi bmi;
    public Dod dod;
    public Ymca ymca;
    public Hb hb;
    public Rs rs;
    public Msj msj;
}
