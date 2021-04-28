package tef.smarth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tef.smarth.entity.UserEntity;
import tef.smarth.mapper.UserMapper;
import tef.smarth.model.AddDataModel;
import tef.smarth.model.User;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.*;
import tef.smarth.utils.UserValidator;

import java.util.Random;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecordService recordService;

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

    @GetMapping("/bmi")
    public String getBmi(Model model) {
        return "bmi";
    }

    @GetMapping("/fitness")
    public String getfitness(Model model) {
        return "fitness";
    }

    @GetMapping("/recommendations")
    public String getRecommendations(Model model) {
        Random rand = new Random();
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("recommendations", recommendationService.getRecommendations(rand.nextInt(30)) );
        return "recommendations";
    }

    @GetMapping("/profile-data")
    public String personalCabinet(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        return "profile-data";
    }

    @GetMapping("/add-data")
    public String addData(Model model) {

        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("saved", false);
        return "add-data";
    }

    @PostMapping("/add-data")
    public String addDataForm(Model model, @ModelAttribute("addForm")AddDataModel addDataModel, BindingResult bindingResult) {
        recordService.saveRecords(addDataModel);
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
       model.addAttribute("saved", true);
        return "add-data";
    }

    @GetMapping("/medical-calculations")
    public String getCalculations(Model model) {

        model.addAttribute("user", userService.obtainCurrentPrincipleUser());

        return "medical-calculations";
    }


    @GetMapping("/summary")
    public String getSummary(Model model) {
        UserEntity userEntity = userService.obtainCurrentPrincipleUser();
        model.addAttribute("user", userEntity);
        mailService.sendMailWithAttachment(userEntity);
        return "summary";
    }

    @PostMapping("/updateUser")
    public String updateUser(Model model, @ModelAttribute("userUpdate") User user, BindingResult bindingResult) {

        userValidator.validateOnUpdate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userService.obtainCurrentPrincipleUser());
            logger.info("reg. form had errors. redirecting");
            return "profile-data";
        }
        model.addAttribute("user", userMapper.convertToModel(userService.updateCurrentUser(userMapper.convertToEntity(user))));
        return "profile-data";
    }


}
