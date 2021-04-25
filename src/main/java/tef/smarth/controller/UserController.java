package tef.smarth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tef.smarth.entity.UserEntity;
import tef.smarth.mapper.UserMapper;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.MailService;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;

@Controller
public class UserController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile-data")
    public String personalCabinet() {
        return "profile-data";
    }

    @GetMapping("/add-data")
    public String addData() {
        return "add-data";
    }

    @GetMapping("/medical-calculations")
    public String getCalculations() {
        return "medical-calculations";
    }

    @GetMapping("/recommendations")
    public String getRecommendations() {
        return "recommendations";
    }

    @GetMapping("/bmi")
    public String getBmi() {
        return "bmi";
    }

    @GetMapping("/fitness")
    public String getfitness() {
        return "fitness";
    }

    @GetMapping("/summary")
    public String getSummary(Model model) {
        UserEntity userEntity = userService.obtainCurrentPrincipleUser();
    //    mailService.sendMailWithAttachment(securityService.findLoggedInUser());
        model.addAttribute("user", userMapper.convertToModel(userEntity));
        return "summary";
    }

    @GetMapping("/lexigram")
    public String getlexigram() {
        return "lexigram";
    }

    @GetMapping("/spoon")
    public String getSpoon() {
        return "spoony";
    }

    @GetMapping("/covid")
    public String getCovid() {
        return "covid";
    }
}
