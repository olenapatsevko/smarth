package tef.smarth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tef.smarth.api.bmi.BMIClient;
import tef.smarth.api.bmi.request.BMIParameter;
import tef.smarth.api.bmi.request.BMIRequest;
import tef.smarth.api.bmi.response.BMIResponse;
import tef.smarth.dto.MailRequest;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.Sex;
import tef.smarth.repository.UserRepository;
import tef.smarth.utils.DateUtil;

@RestController
@RequestMapping("/api")
public class BMIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BMIClient bmiClient;

    @PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public BMIResponse postBMI(@RequestBody MailRequest mailRequest) {
        UserEntity userEntity = userRepository.findByEmail(mailRequest.getEmail());
        return bmiClient.post(BMIRequest.builder()
                .age(String.valueOf(DateUtil.calculateAge(userEntity.getBirthday().toLocalDate())))
                .height(BMIParameter.builder()
                        .value(userEntity.getHeight() + ".00")
                        .unit("cm")
                        .build())
                .sex(userEntity.getSex().equals(Sex.MALE) ? "m" : "f")
                .weight(BMIParameter.builder()
                        .value(userEntity.getWeight() + ".00")
                        .unit("kg")
                        .build())
                .hip(userEntity.getHip() + ".00")
                .waist(userEntity.getWaist() + ".00")
                .build(), userEntity);
    }
}
