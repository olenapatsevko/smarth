package tef.smarth.api.bmi.request;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class BMIParameter {

    String value;
    String unit;
}
