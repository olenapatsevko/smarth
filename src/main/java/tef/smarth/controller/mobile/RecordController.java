package tef.smarth.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tef.smarth.dto.RecordRequest;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.RecordRepository;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.SecurityService;
import tef.smarth.service.UserService;
import tef.smarth.utils.UserValidator;

@RestController
@RequestMapping("/api")
public class RecordController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepository userService;

    @Autowired
    private RecordRepository recordRepository;

    @ResponseStatus(HttpStatus.OK)
@PostMapping("/insertData")
    public void insertData (@RequestBody RecordRequest request){
        UserEntity user = userService.findByEmail(request.getEmail());
}
}
