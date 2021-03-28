package tef.smarth.api.bmi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tef.smarth.api.bmi.request.BMIParameter;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;
import tef.smarth.repository.RecordRepository;
import tef.smarth.service.UserService;

import javax.xml.ws.WebServiceClient;
import java.sql.Date;

@Data
@Service
public class BMIClient {

    @Autowired
    private RecordRepository recordRepository;


    static final String URL = "https://bmi.p.rapidapi.com/";



    public BMIResponse post(BMIRequest request, UserEntity userEntity) {

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
                .user(userEntity)
                .value(bmiResponse != null ? bmiResponse.getBmi().value : null)
                .build());
        return bmiResponse;
    }
}
