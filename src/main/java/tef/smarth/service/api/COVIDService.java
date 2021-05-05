package tef.smarth.service.api;


import tef.smarth.api.covid.tracking.response.CountryCOVID;

import java.util.List;

public interface COVIDService {

    List<CountryCOVID> getAllCountries();

    CountryCOVID getUkraine();
    CountryCOVID getWorld();
}
