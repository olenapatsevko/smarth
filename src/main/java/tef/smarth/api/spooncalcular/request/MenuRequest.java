package tef.smarth.api.spooncalcular.request;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class MenuRequest extends SpoonRequest{
    String timeFrame;
    double targetCalories;
    String diet;
    String exclude;
}
