package tef.smarth.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tef.smarth.service.UserService;
import tef.smarth.service.impl.UserDetailsServiceImpl;

@Controller
@RequestMapping({"/", "/welcome", "/main"})
@Data
public class MainController {

    private UserService userService;
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping
    public String getMainPage(Model model) {
        return "index";
    }
}
