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
public class Imperial{
    public double value;
    public List<String> unit;
}
