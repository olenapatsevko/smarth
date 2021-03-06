package tef.smarth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.bmi.BMIClient;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.dto.MailRequest;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.api.BMIService;

@RestController
@RequestMapping("/api")
public class BMIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BMIClient bmiClient;

    @Autowired
    private BMIService bmiService;

    @PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public BMIResponse postBMI(@RequestBody MailRequest mailRequest) {
        var userEntity = userRepository.findByEmail(mailRequest.getEmail());
        return bmiService.getBMI(userEntity);
    }
}
