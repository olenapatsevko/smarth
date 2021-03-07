package tef.smarth.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tef.smarth.controller.api.CareApi;
import tef.smarth.controller.api.PressureApi;
import tef.smarth.controller.api.SugarApi;
import tef.smarth.service.UserDetailsServiceImpl;
import tef.smarth.service.UserService;

@Controller
@Data
public class MainController {

    private CareApi careApi;
    private PressureApi pressureApi;
    private SugarApi sugarApi;

    private UserService userService;
    private UserDetailsServiceImpl userDetailsService;





}
