
package tef.smarth.api.spooncalcular.response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

import java.util.List;
import javax.annotation.Generated;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class Response {

    private List<Meal> meals;

    private Nutrients nutrients;
}
