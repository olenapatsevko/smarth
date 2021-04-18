package tef.smarth.service;

import tef.smarth.dto.Record;
import tef.smarth.entity.Calculation;
import tef.smarth.entity.RecordEntity;

public interface CalculationService {

    Calculation caluclateRitis(Record ast, Record alt);
}
