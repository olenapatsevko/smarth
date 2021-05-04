package tef.smarth.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientsForm {
    private int number;
    private String ingredients;
}
