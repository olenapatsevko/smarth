package tef.smarth.controller.inner.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/getSummary")
    public void getSummary(@RequestBody MailRequest mailRequest) {
            mailService.sendMailWithAttachment(  userRepository.findByEmail(mailRequest.getEmail()), mailRequest.getEmail());
    }
}
