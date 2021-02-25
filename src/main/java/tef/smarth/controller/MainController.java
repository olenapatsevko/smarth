package tef.smarth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
        return "singup";
    }

}
