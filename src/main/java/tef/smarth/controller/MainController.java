package tef.smarth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/","/main"})
    public  String getMain(Model model){
        return "index";
    }

    @GetMapping("/chart")
    public String getChart(){
        return "chart";
    }
}
