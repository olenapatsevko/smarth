package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasalMetabolicRate{
    public Hb hb;
    public Rs rs;
    public Msj msj;
}
