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
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.UserDto;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
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



    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.info("reg. form had errors. redirecting");
            return "registration";
        }

        userService.registerUser(userForm);
        securityService.autoLoginAfterReg(userForm.getUsername(), userForm.getPasswordConfirm());

        logger.info("user registered");
        return "redirect:/registration";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, Model model) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
        securityService.login(userDto.getUsername(), userDto.getPassword());
        return "redirect:/registration";
    }

    @GetMapping("/personal-cabinet")
    public String personalCabinet() {
        return "personal-cabinet";
    }


}
