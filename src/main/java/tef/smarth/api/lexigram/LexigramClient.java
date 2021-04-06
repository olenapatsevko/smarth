package tef.smarth.api.lexigram;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LexigramClient {
    /*
      Replace YOUR_KEY_HERE with your API KEY from your user profile at https://app.lexigram.io
      */
    private static String API_KEY = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdSI6Imx4ZzphcGkiLCJzYyI6WyJrZzpyZWFkIiwiZXh0cmFjdGlvbjpyZWFkIl0sImFpIjoiYXBpOmRhZDNkYWY5LWQ4NzctYjI5Mi1jZmIzLTQ5NTBmZDQ3ZjY2OCIsInVpIjoidXNlcjo2YWQ1YjE5NS1kMTNlLWJjMTUtZGVkYy1kYjRhMGM0ODRmYTQiLCJpYXQiOjE2MTc3MzYyNDZ9.oxCWf0OybOHq8RPHUH7TJ4JSrfFgmazfY0p3EXMQS7o";

    /*
    Entity extraction from a note sample.
    */
    public Object exampleEntityExtraction() {
        String url = "https://api.lexigram.io/v1/extract/entities";
        String text = "The patient was given some hydrocodone for control of her pain." +
                "The patient suffers from bulimia and eating disorder, bipolar disorder," +
                " and severe hypokalemia. She thinks her potassium might again be low.";
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestBody = new HttpEntity(text, headers);

        ResponseEntity response
                = restTemplate.postForEntity(url, requestBody, String.class);
        return response.getBody();
    }

    /*
    Entity highlight from a note sample.
    */
    public Object exampleHighlightEntities() {
        String text = "The patient was given some hydrocodone for control of her pain." +
                "The patient suffers from bulimia and eating disorder, bipolar disorder," +
                " and severe hypokalemia. She thinks her potassium might again be low.";
        String url = "https://api.lexigram.io/v1/highlight/entities";

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestBody = new HttpEntity(text, headers);

        ResponseEntity response
                = restTemplate.postForEntity(url, requestBody, String.class);
        return response.getBody();
    }

    /*
    Keyword search of "diabetes"
    */
    public Object exampleSearchConcepts() {
        String keyword = "diabetes";
        String url = "https://api.lexigram.io/v1/lexigraph/search?q=" + keyword;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity response
                = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    /*
    Concept IDs are returned by API calls like search and data extraction
    and the 'concepts' endpoint allows you to get more information about
    that particular concept.
    */
    public Object exampleConcept() {
        String conceptGraphId = "lxg:49711bf9b46f"; /* concept Id for heart failure*/
        String url = "https://api.lexigram.io/v1/lexigraph/concepts/" + conceptGraphId;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity response
                = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    /*
    Ancestors of heart failure concept are returned
    */
    public Object exampleConceptAncestors() {
        String conceptGraphId = "lxg:49711bf9b46f"; /* concept Id for heart failure*/
        String url = "https://api.lexigram.io/v1/lexigraph/concepts/" + conceptGraphId + "/ancestors";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity response
                = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    /*
    Descendants of heart failure concept are returned
    */
    public Object exampleConceptDescendants() {
        String conceptGraphId = "lxg:49711bf9b46f"; /* concept Id for heart failure*/
        String url = "https://api.lexigram.io/v1/lexigraph/concepts/" + conceptGraphId + "/descendants";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", API_KEY);
        headers.add("content-type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity response
                = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}