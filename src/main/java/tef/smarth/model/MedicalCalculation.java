package tef.smarth.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalCalculation {

    private List<Calculation> calculations;

    private List<String> explanations;
}
