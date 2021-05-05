
package tef.smarth.api.spooncalcular.response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return
                "Unused Ingredients: " + StringUtils.join(unusedIngredients.stream().map(UnusedIngredient::toString).collect(Collectors.toList()), ',') + "<br/>" +
                        "Used IngredientCount: " + usedIngredientCount + "<br/>" +
                        "Missed Ingredients: " + missedIngredientCount + "<br/>" +
                        "Used Ingredients: " + StringUtils.join(usedIngredients.stream().map(UsedIngredient::toString).collect(Collectors.toList()), ',') + "<br/>";
    }
}
