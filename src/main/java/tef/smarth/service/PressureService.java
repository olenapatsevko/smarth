package tef.smarth.service;

import lombok.Data;
import tef.smarth.model.api.entities.Pressure;

@Data
public class PressureService implements Service<Pressure>{

    private Pressure pressure;

    @Override
    public Pressure process(Object o) {
        return null;
    }
}
