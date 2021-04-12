package tef.smarth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.spooncalcular.SpoonCalcularClient;
import tef.smarth.api.spooncalcular.request.DietType;
import tef.smarth.api.spooncalcular.request.GenerateMenuRequest;
import tef.smarth.api.spooncalcular.request.TimeFrame;
import tef.smarth.api.spooncalcular.response.GenerateMenuResponse;
import tef.smarth.api.spooncalcular.response.Summary;
import tef.smarth.entity.UserEntity;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class SpoonController {

    @Autowired
    private SpoonCalcularClient covidClient;

    @GetMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenerateMenuResponse getMenu(Model model) {
        return covidClient.getMenu(GenerateMenuRequest.builder()
                .diet(DietType.Ketogenic.getName().toLowerCase(Locale.ROOT))
                .targetCalories(200)
                .timeFrame(TimeFrame.DAY.name())
                .build(), new UserEntity()
        );
    }

    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Summary getSummary(Model model) {
        return covidClient.getRecipe(111);
    }
}
