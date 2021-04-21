package tef.smarth.service;

import org.springframework.stereotype.Service;
import tef.smarth.model.Record;
import tef.smarth.entity.CalculationEntity;

@Service
public interface CalculationService {

    CalculationEntity caluclateRitis(Record ast, Record alt);
}
