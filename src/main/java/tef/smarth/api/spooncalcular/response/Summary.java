
package tef.smarth.api.spooncalcular.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summary {

    private Long id;

    private String summary;

    private String title;
}
