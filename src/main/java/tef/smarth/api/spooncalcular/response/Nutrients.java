
package tef.smarth.api.spooncalcular.response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class Nutrients {

    private Double calories;

    private Double carbohydrates;

    private Double fat;

    private Double protein;


}
