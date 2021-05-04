
package tef.smarth.api.spooncalcular.response;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerializableSchema
public class UnusedIngredient {


    private String aisle;

    private Double amount;

    private Long id;

    private String image;

    private List<Object> meta;

    private List<Object> metaInformation;

    private String name;

    private String original;

    private String originalName;

    private String originalString;

    private String unit;

    private String unitLong;

    private String unitShort;
}
