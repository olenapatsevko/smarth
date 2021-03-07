package tef.smarth.controller.api;

import lombok.Data;
import tef.smarth.model.api.entities.CarbonFootPrint;
import tef.smarth.service.CarbonFootprintService;

@Data
public class CareApi implements Api<CarbonFootPrint>{

    private CarbonFootprintService carbonFootPrint;
    @Override
    public CarbonFootPrint processRequest() {
        return null;
    }
}
