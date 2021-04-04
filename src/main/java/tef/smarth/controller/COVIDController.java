package tef.smarth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.covid.tracking.COVIDClient;
import tef.smarth.api.covid.tracking.response.CountryCOVID;

import java.util.List;

@RestController
@RequestMapping("/api")
public class COVIDController {

    @Autowired
    private COVIDClient covidClient;

    @GetMapping(value = "/covid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryCOVID> postBMI(Model model) {
        return covidClient.get();
    }
}
