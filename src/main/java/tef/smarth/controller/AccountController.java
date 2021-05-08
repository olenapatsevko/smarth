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
import tef.smarth.model.User;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
import tef.smarth.service.api.COVIDService;
import tef.smarth.utils.UserValidator;


@Controller
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private COVIDService covidService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.info("reg. form had errors. redirecting");
            return "registration";
        }

        userService.registerUser(userMapper.convertToEntity(user));
        securityService.autoLoginAfterReg(user.getUsername(), user.getPassword());
        logger.info("user registered");
        return "redirect:/personal-cabinet";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userDto", new User());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
        securityService.login(user.getUsername(), user.getPassword());
        return "redirect:/registration";
    }

    @GetMapping("/personal-cabinet")
    public String personalCabinet(Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("allCountries", covidService.getAllCountries());
        model.addAttribute("ukraine", covidService.getUkraine());
        model.addAttribute("world", covidService.getWorld());
        return "personal-cabinet";
    }
    @GetMapping("/client/personal-cabinet")
    public String personalCabinet2 (Model model) {
        model.addAttribute("user", userService.obtainCurrentPrincipleUser());
        model.addAttribute("allCountries", covidService.getAllCountries());
        model.addAttribute("ukraine", covidService.getUkraine());
        model.addAttribute("world", covidService.getWorld());
        return "personal-cabinet";
    }


}
