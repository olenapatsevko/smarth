package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.entity.CalculationEntity;
import tef.smarth.entity.enums.CalculationType;
import tef.smarth.entity.enums.Measurements;
import tef.smarth.model.Record;
import tef.smarth.repository.CalculationRepository;
import tef.smarth.service.CalculationService;
import tef.smarth.service.SecurityService;

import static tef.smarth.utils.DateUtil.getCurrentSqlDate;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private CalculationRepository calculationRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public CalculationEntity caluclateRitis(Record ast, Record alt) {
        return calculationRepository.save(
                CalculationEntity.builder()
                        .date(getCurrentSqlDate())
                        .user(securityService.findLoggedInUser())
                        .name(CalculationType.RITIS)
                        .value(Double.parseDouble(ast.getValue()) / Double.parseDouble(alt.getValue()))
                        .measurement(Measurements.PERCENT)
                        .meaning("")
                        .build());
    }
}
