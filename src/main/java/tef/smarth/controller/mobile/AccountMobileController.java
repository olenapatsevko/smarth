package tef.smarth.controller.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.UserDto;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
import tef.smarth.utils.UserValidator;

import java.net.http.HttpResponse;

@Controller
@RequestMapping("/api")
public class AccountMobileController {

    private final Logger logger = LoggerFactory.getLogger(AccountMobileController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/registration")
    public HttpResponse registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.info("reg. form had errors. redirecting");

        }
        userService.registerUser(userForm);
        securityService.autoLoginAfterReg(userForm.getUsername(), userForm.getPasswordConfirm());
        logger.info("user registered");
        return null;
        }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, Model model) {
        securityService.login(userDto.getUsername(), userDto.getPassword());
        return "redirect:/registration";
    }
}
