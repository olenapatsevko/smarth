package tef.smarth.api.spooncalcular.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateMenuResponse {


    private List<Meal> meals;

    private Nutrients nutrients;
}
