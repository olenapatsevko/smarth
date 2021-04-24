package tef.smarth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile-data")
    public String personalCabinet() {
        return "profile-data";
    }

    @GetMapping("/add-data")
    public String addData() {
        return "add-data";
    }

    @GetMapping("/medical-calculations")
    public String getCalculations() {
        return "medical-calculations";
    }

    @GetMapping("/recommendations")
    public String getRecommendations() {
        return "recommendation";
    }

    @GetMapping("/bmi")
    public String getBmi() {
        return "summary";
    }

    @GetMapping("/summary")
    public String getfitness() {
        return "fitness";
    }

    @GetMapping("/lexigram")
    public String getlexigram() {
        return "lexigram";
    }

    @GetMapping("/spoon")
    public String getSpoon() {
        return "spoony";
    }

    @GetMapping("/covid")
    public String getCovid() {
        return "covid";
    }
}
