package tef.smarth.controller.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tef.smarth.dto.RegistrationRequest;
import tef.smarth.controller.mobile.mapper.UserMapper;
import tef.smarth.dto.RegistrationResponse;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.UserDto;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
import tef.smarth.service.impl.RecommendationServiceImpl;
import tef.smarth.utils.RegistrationValidator;
import tef.smarth.utils.UserUtils;
import tef.smarth.utils.UserValidator;

@RestController
@RequestMapping("/api")
public class AccountMobileController {

    private final Logger logger = LoggerFactory.getLogger(AccountMobileController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecommendationServiceImpl recommendationService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/registration")
    public RegistrationResponse registration(@RequestBody RegistrationRequest user) {
       // if (registrationValidator.isValid(user)){
            userService.registerUser(UserUtils.getUserEntity(user));
            logger.info("user registered");
            return RegistrationResponse.builder().registrationSuccess(true).build();
     //   }
  //          return RegistrationResponse.builder().registrationSuccess(false).error("Validation failed").build();
        }

    @GetMapping("/login")
    public ResponseEntity<UserDto> userAccount() {
        //Requests from mobile are coming with 'Authorization header'
        //so we can just get CURRENT user instead of searching in db
        UserEntity currentUser = userService.obtainCurrentPrincipleUser();
        UserDto dto = UserMapper.toDto(currentUser);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
