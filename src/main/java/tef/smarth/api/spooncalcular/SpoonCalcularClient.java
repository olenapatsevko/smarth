package tef.smarth.api.spooncalcular;

import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tef.smarth.api.spooncalcular.request.DietType;
import tef.smarth.api.spooncalcular.request.GenerateMenuRequest;
import tef.smarth.api.spooncalcular.request.TimeFrame;
import tef.smarth.api.spooncalcular.response.GenerateMenuResponse;
import tef.smarth.api.spooncalcular.response.Summary;
import tef.smarth.entity.UserEntity;

import java.util.Locale;
import java.util.Map;

@Data
@Service
public class SpoonCalcularClient {

    static final String URL = "https://api.spoonacular.com/mealplanner/generate";
    static final String SECURITY_KEY = "a779e9aaa0fd400fa13a9994ff7f7091";
    static final String URL_2= "https://api.spoonacular.com/recipes/{id}/summary";

    public GenerateMenuResponse getMenu(GenerateMenuRequest request, UserEntity userEntity) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("apiKey", SECURITY_KEY)
                .queryParam("timeFrame", TimeFrame.DAY.getCode())
                .queryParam("diet", DietType.Vegan.getName().toLowerCase(Locale.ROOT))
                .queryParam("targetCalories", 20000);
                //.queryParam("exclude", "onion,fish");

        headers.add("x-rapidapi-key", SECURITY_KEY);
        //    headers.add("x-rapidapi-host", "bmi.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenerateMenuRequest> requestBody = new HttpEntity<>(headers);

        ResponseEntity<GenerateMenuResponse> response
                = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestBody, GenerateMenuResponse.class);
        return response.getBody();
    }

    public Summary getRecipe( int id) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_2)
                .queryParam("apiKey", SECURITY_KEY)
                .uriVariables(Map.of("id",474380));

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenerateMenuRequest> requestBody = new HttpEntity<>(headers);

        ResponseEntity<Summary> response
                = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestBody, Summary.class);
        return response.getBody();
    }
}
