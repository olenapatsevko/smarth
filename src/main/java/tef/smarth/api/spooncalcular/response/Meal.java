
package tef.smarth.api.spooncalcular.response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;


@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class Meal {

    private Long id;

    private String imageType;

    private Long readyInMinutes;

    private Long servings;

    private String sourceUrl;

    private String title;
}
