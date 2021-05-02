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
import tef.smarth.api.spooncalcular.request.DietType;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.mapper.UserMapper;
import tef.smarth.model.AddDataModel;
import tef.smarth.model.Fitness;
import tef.smarth.model.Menu;
import tef.smarth.model.User;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.*;
import tef.smarth.service.api.BMIService;
import tef.smarth.service.api.FitnessService;
import tef.smarth.service.api.SpoonService;
import tef.smarth.utils.RecordValidator;
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

    @Autowired
    private RecordValidator recordValidator;

    @Autowired
    private FitnessService fitnessService;

    @Autowired
    private BMIService bmiService;

    @Autowired
    private SpoonService spoonService;

    @GetMapping("/analyser")
    public String getlexigram(Model model) {
        model.addAttribute("user",  userService.obtainCurrentPrincipleUser());
        return "analyser";
    }

    @GetMapping("/nutrition")
    public String getSpoon(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("diets", DietType.values());
        model.addAttribute("menuForm", new Menu());
        return "nutrition";
    }

    @PostMapping("/nutrition")
    public String getSpoon(Model model, @ModelAttribute("menuForm") Menu menu) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("menu", spoonService.getMenu(menu));
        return "nutrition-result";
    }

    @GetMapping("/covid")
    public String getCovid(Model model) {

        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        return "covid";
    }

    @GetMapping("/bmi")
    public String getBMI(Model model) {
        UserEntity userEntity = userService.obtainCurrentPrincipleUser();
        model.addAttribute("user", userEntity);
        model.addAttribute("bmiResult", bmiService.getBMI(userEntity));
        return "bmi";
    }

    @GetMapping("/fitness")
    public String getFitness(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("fitnessForm", new Fitness());
        return "fitness";
    }

    @PostMapping("/fitness")
    public String postFitness(Model model, @ModelAttribute("fitnessForm") Fitness fitness) {
        UserEntity userEntity = userService.obtainCurrentPrincipleUser();
        model.addAttribute("fitnessResult", fitnessService.getFitnessPlan(userEntity, fitness));
        model.addAttribute("user", userEntity);
        return "fitness-result";
    }

    @GetMapping("/recommendations")
    public String getRecommendations(Model model) {
        Random rand = new Random();
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("recommendations", recommendationService.getRecommendations(rand.nextInt(30)));
        return "recommendations";
    }

    @GetMapping("/profile-data")
    public String personalCabinet(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("userUpdate", userService.obtainCurrentPrincipleUser());
        return "profile-data";
    }

    @GetMapping("/add-data")
    public String addData(Model model) {
        model.addAttribute("addForm", new AddDataModel());
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("saved", false);
        return "add-data";
    }

    @PostMapping("/add-data")
    public String addDataForm(Model model, @ModelAttribute("addForm")AddDataModel addDataModel, BindingResult bindingResult) {
        recordValidator.validate(addDataModel,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userService.obtainCurrentPrincipleUser());
            logger.info("reg. form had errors. redirecting");
           return "add-data";
        }
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
        mailService.sendMailWithAttachment(userEntity,null);
        model.addAttribute("send",false);
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

    @PostMapping("/summary-to-doctor")
    public String summaryToDoctor(Model model, String email){
        UserEntity userEntity = userService.obtainCurrentPrincipleUser();
        model.addAttribute("user", userEntity);
        mailService.sendMailWithAttachment(userEntity, email);
        model.addAttribute("send",true);
        return "summary";
    }
}
