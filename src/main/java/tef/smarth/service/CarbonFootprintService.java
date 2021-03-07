package tef.smarth.service;

import lombok.Data;
import tef.smarth.model.api.entities.CarbonFootPrint;

@Data
public class CarbonFootprintService implements Service<CarbonFootPrint>{

    private CarbonFootPrint carbonFootprint;

    @Override
    public CarbonFootPrint process(Object o) {
        return null;
    }
}
