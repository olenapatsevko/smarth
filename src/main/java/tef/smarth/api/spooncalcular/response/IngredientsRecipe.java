
package tef.smarth.api.spooncalcular.response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

import java.util.List;


@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class IngredientsRecipe {


    private Long id;

    private String image;

    private String imageType;

    private Long likes;

    private Long missedIngredientCount;

    private List<MissedIngredient> missedIngredients;

    private String title;

    private List<UnusedIngredient> unusedIngredients;

    private Long usedIngredientCount;

    private List<UsedIngredient> usedIngredients;
}
