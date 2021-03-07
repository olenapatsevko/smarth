package tef.smarth.controller.api;

import lombok.Data;
import tef.smarth.model.api.entities.Pressure;
import tef.smarth.service.PressureService;

@Data
public class PressureApi implements Api<Pressure> {

    private PressureService pressure;

    @Override
    public Pressure processRequest() {
        return null;
    }
}