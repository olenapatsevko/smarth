package tef.smarth.api.bmi;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.Measurements;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;
import tef.smarth.repository.RecordRepository;

import java.sql.Date;

@Data
@Service
public class BMIClient {

    @Autowired
    private RecordRepository recordRepository;

    static final String URL = "https://bmi.p.rapidapi.com/";
    static final String SECURITY_KEY = "0e4c7b750emsh12711b9e7f9a209p18dcaajsn9cfc950971cc";

    public BMIResponse post(BMIRequest request, UserEntity userEntity) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", SECURITY_KEY);
        headers.add("x-rapidapi-host", "bmi.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BMIRequest> requestBody = new HttpEntity<>(request, headers);

        ResponseEntity<BMIResponse> response
                = restTemplate.postForEntity(URL, requestBody, BMIResponse.class);
        return getResponse(userEntity, response);
    }

    private BMIResponse getResponse(UserEntity userEntity, ResponseEntity<BMIResponse> response) {
        BMIResponse bmiResponse = response.getBody();
        recordRepository.save(RecordEntity.builder()
                .name(ParameterType.MASS_INDEX.getValue())
                .date(new Date(System.currentTimeMillis()))
                .recordType(RecordType.DOUBLE)
                .measurement(Measurements.NONE)
                .parameterType(ParameterType.MASS_INDEX)
                .user(userEntity)
                .value(bmiResponse != null ? bmiResponse.getBmi().value : null)
                .build());
        return bmiResponse;
    }
}
