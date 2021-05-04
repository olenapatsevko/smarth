package tef.smarth.api.spooncalcular;

import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tef.smarth.api.spooncalcular.request.IngredientsRequest;
import tef.smarth.api.spooncalcular.request.MenuRequest;
import tef.smarth.api.spooncalcular.request.TimeFrame;
import tef.smarth.api.spooncalcular.response.IngredientsRecipe;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.Menu;

import java.util.Locale;
import java.util.Map;

@Data
@Service
public class SpoonCalcularClient {

    static final String URL = "https://api.spoonacular.com/mealplanner/generate";
    static final String SECURITY_KEY = "a779e9aaa0fd400fa13a9994ff7f7091";
    static final String URL_2 = "https://api.spoonacular.com/recipes/{id}/summary";
    static final String URL_3 = "https://api.spoonacular.com/recipes/findByIngredients";
    public static final String API_KEY = "apiKey";

    public MenuResponse getMenu(Menu request) {

        var restTemplate = new RestTemplate();

        var headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam(API_KEY, SECURITY_KEY)
                .queryParam("timeFrame", TimeFrame.DAY.getCode())
                .queryParam("diet", request.getDiet().getName().toLowerCase(Locale.ROOT))
                .queryParam("targetCalories", request.getTargetCalories());


        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MenuRequest> requestBody = new HttpEntity<>(headers);

        ResponseEntity<MenuResponse> response
                = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestBody, MenuResponse.class);
        return response.getBody();
    }

    public SpoonRecipeSummary getRecipe(int id) {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_2)
                .queryParam(API_KEY, SECURITY_KEY)
                .uriVariables(Map.of("id", id));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MenuRequest> requestBody = new HttpEntity<>(headers);

        ResponseEntity<SpoonRecipeSummary> response
                = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestBody, SpoonRecipeSummary.class);
        return response.getBody();
    }

    public Object getRecipesByIngredients(IngredientsRequest request) {
        var restTemplate = new RestTemplate();

        var headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_3)
                .queryParam(API_KEY, SECURITY_KEY)
                .queryParam("ingredients", String.join(",+", request.getIngredients()))
                .queryParam("number", request.getNumber());


        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MenuRequest> requestBody = new HttpEntity<>(headers);

        ResponseEntity<IngredientsRecipe[]> response
                = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestBody, IngredientsRecipe[].class);
        return response.getBody();
    }
}
