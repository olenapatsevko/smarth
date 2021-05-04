package tef.smarth.api.spooncalcular.request;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class IngredientsRequest {
    int number;
    List<String> ingredients;
}
