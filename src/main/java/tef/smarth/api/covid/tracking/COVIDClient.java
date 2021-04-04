package tef.smarth.api.covid.tracking;

import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tef.smarth.api.covid.tracking.response.CountryCOVID;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class COVIDClient {


    static final String URL = "https://covid-19-tracking.p.rapidapi.com/v1";
    static final String SECURITY_KEY = "0e4c7b750emsh12711b9e7f9a209p18dcaajsn9cfc950971cc";

    public List<CountryCOVID> get() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", SECURITY_KEY);
        headers.add("x-rapidapi-host", "covid-19-tracking.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<CountryCOVID[]> response
                = restTemplate.exchange(URL, HttpMethod.GET, entity, CountryCOVID[].class);
        return getResponse(response);
    }

    private List<CountryCOVID> getResponse(ResponseEntity<CountryCOVID[]> response) {
        return List.of(response.getBody());
    }
}
