package tef.smarth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import tef.smarth.dto.MailRequest;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.MailService;

@Controller
@RequestMapping("/api")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserRepository userRepository;


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/getSummary")
    public void getSummary(@RequestBody MailRequest mailRequest) {
            mailService.sendMailWithAttachment(  userRepository.findByEmail(mailRequest.getEmail()));
    }
}
