package tef.smarth.api.fitness;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tef.smarth.api.fitness.request.FitnessRequest;
import tef.smarth.repository.RecordRepository;

@Data
@Service
public class FitnessClient {

    @Autowired
    private RecordRepository recordRepository;

    static final String URL = "https://fitness-api.p.rapidapi.com/fitness";
    static final String SECURITY_KEY = "0e4c7b750emsh12711b9e7f9a209p18dcaajsn9cfc950971cc";

    public Object post(FitnessRequest request) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", SECURITY_KEY);
        headers.add("x-rapidapi-host", "fitness-api.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FitnessRequest> requestBody = new HttpEntity<>(request, headers);

        ResponseEntity response
                = restTemplate.postForEntity(URL, requestBody, String.class);
        return response.getBody();
    }
}
