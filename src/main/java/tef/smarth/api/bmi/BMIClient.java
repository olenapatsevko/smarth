package tef.smarth.api.bmi;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tef.smarth.api.bmi.request.BMIParameter;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;
import tef.smarth.repository.RecordRepository;
import tef.smarth.service.UserService;

import javax.xml.ws.WebServiceClient;
import java.sql.Date;

@WebServiceClient
@Data
@NoArgsConstructor
@Component
public class BMIClient {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private  UserService userService;


    static final String URL = "https://bmi.p.rapidapi.com/";
    static final String SECURITY_KEY = "0e4c7b750emsh12711b9e7f9a209p18dcaajsn9cfc950971cc";


    public BMIResponse post(BMIRequest request) {
        request.setSex("m");
        request.setWeight(new BMIParameter("60.00", "kg"));
        request.setHeight(new BMIParameter("176.00", "cm"));
        request.setAge("20");
        request.setHip("40.00");
        request.setWaist("34.00");


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", SECURITY_KEY);
        headers.add("x-rapidapi-host", "bmi.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BMIRequest> requestBody = new HttpEntity<>(request, headers);

        ResponseEntity<BMIResponse> response
                = restTemplate.postForEntity(URL, requestBody, BMIResponse.class);
        BMIResponse bmiResponse = response.getBody();
        recordRepository.save(RecordEntity.builder()
                .date(new Date(System.currentTimeMillis()))
                .recordType(RecordType.DOUBLE)
                .parameterType(ParameterType.MASS_INDEX)
                .user(userService.obtainCurrentPrincipleUser())
                .value(bmiResponse != null ? bmiResponse.getBmi().value : null)
                .build());
        return bmiResponse;
    }
}
