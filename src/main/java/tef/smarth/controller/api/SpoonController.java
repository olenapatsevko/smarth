package tef.smarth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.spooncalcular.SpoonCalcularClient;
import tef.smarth.api.spooncalcular.request.DietType;
import tef.smarth.api.spooncalcular.request.TimeFrame;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.Menu;

@RestController
@RequestMapping("/api")
public class SpoonController {

    @Autowired
    private SpoonCalcularClient covidClient;

    @GetMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuResponse getMenu(Model model) {
        return covidClient.getMenu(Menu.builder()
                .diet(DietType.Ketogenic)
                .targetCalories(200)
                .time(TimeFrame.DAY)
                .build()
        );
    }
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public SpoonRecipeSummary getSummary(Model model) {
        return covidClient.getRecipe(111);
    }
}
