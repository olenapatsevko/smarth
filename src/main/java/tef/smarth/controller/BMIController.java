package tef.smarth.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.bmi.BMIClient;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;

@RestController
@RequestMapping("/api")
public class BMIController {


    @GetMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public BMIResponse postBMI() {
        BMIClient bmiClient = new BMIClient();
        return bmiClient.post(new BMIRequest());
    }
}
