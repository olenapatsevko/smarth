package tef.smarth.api.fitness.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdealBodyWeight{
    public Peterson peterson;
    public Lorentz lorentz;
    public Hamwi hamwi;
    public Devine devine;
    public Robinson robinson;
    public Miller miller;
}
