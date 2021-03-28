package tef.smarth.controller.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tef.smarth.dto.RegistrationRequest;
import tef.smarth.dto.RegistrationResponse;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
import tef.smarth.utils.RegistrationValidator;
import tef.smarth.utils.UserUtils;

@RestController
@RequestMapping("/api")
public class AccountMobileController {

    private final Logger logger = LoggerFactory.getLogger(AccountMobileController.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/registration")
    public RegistrationResponse registration(@RequestBody RegistrationRequest user) {
        if (registrationValidator.isValid(user)){
            userService.registerUser(UserUtils.getUserEntity(user));
            logger.info("user registered");
            return RegistrationResponse.builder().registrationSuccess(true).build();
        }
            return RegistrationResponse.builder().registrationSuccess(false).error("Validation failed").build();
        }
}
