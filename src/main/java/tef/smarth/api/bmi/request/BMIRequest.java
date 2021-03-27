package tef.smarth.api.bmi.request;


import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class BMIRequest {

    private BMIParameter weight;

    private BMIParameter height;

    private String sex;

    private String age;

    private String waist;

    private String hip;

}
