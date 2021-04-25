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
    public String personalCabinet(Model model) {
        return "profile-data";
    }

    @GetMapping("/add-data")
    public String addData(Model model) {
        return "add-data";
    }

    @GetMapping("/medical-calculations")
    public String getCalculations(Model model) {
        return "medical-calculations";
    }

    @GetMapping("/recommendations")
    public String getRecommendations(Model model) {
        return "recommendations";
    }

    @GetMapping("/bmi")
    public String getBmi(Model model) {
        return "bmi";
    }

    @GetMapping("/fitness")
    public String getfitness(Model model) {
        return "fitness";
    }

    @GetMapping("/summary")
    public String getSummary(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        return "summary";
    }

    @GetMapping("/lexigram")
    public String getlexigram(Model model) {
        return "lexigram";
    }

    @GetMapping("/spoon")
    public String getSpoon(Model model) {
        return "spoony";
    }

    @GetMapping("/covid")
    public String getCovid(Model model) {
        return "covid";
    }
}
