
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
public class UsedIngredient {

    private String aisle;

    private Double amount;

    private Long id;

    private String image;

    private List<String> meta;

    private List<String> metaInformation;

    private String name;

    private String original;

    private String originalName;

    private String originalString;

    private String unit;

    private String unitLong;

    private String unitShort;

    @Override
    public String toString() {
        return  " <a href="+image+" >"+name+"("+amount+") </a>" ;

    }
}
