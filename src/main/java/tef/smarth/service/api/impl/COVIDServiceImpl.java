package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.covid.tracking.COVIDClient;
import tef.smarth.api.covid.tracking.response.CountryCOVID;
import tef.smarth.service.api.COVIDService;

import java.util.List;

@Service
public class COVIDServiceImpl implements COVIDService {

    @Autowired
    private COVIDClient covidClient;

    @Override
    public List<CountryCOVID> getAllCountries() {
        return covidClient.get();
    }

    @Override
    public CountryCOVID getUkraine() {
        return covidClient.get().stream().filter(countryCOVID -> countryCOVID.getCountry_text().equals("Ukraine")).findAny().get();
    }

    @Override
    public CountryCOVID getWorld() {
        return covidClient.get().stream().filter(countryCOVID -> countryCOVID.getCountry_text().equals("World")).findAny().get();
    }
}
