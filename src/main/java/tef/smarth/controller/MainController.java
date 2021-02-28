package tef.smarth.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tef.smarth.controller.api.CareApi;
import tef.smarth.controller.api.HealthApi;
import tef.smarth.controller.api.SugarApi;

@Controller
@Data
public class MainController {

    private CareApi careApi;
    private HealthApi healthApi;
    private SugarApi sugarApi;




    @GetMapping({"/","/main", "/welcome"})
    public  String getMain(Model model){
        return "index";
    }



    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        return "registration";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "login";
    }

}
