package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.CalculationEntity;
import tef.smarth.entity.DiseaseEntity;
import tef.smarth.model.Calculation;
import tef.smarth.model.Disease;

@Mapper(componentModel = "spring")
public interface CalculationsMapper{
    CalculationEntity convertToEntity (Calculation model);

    Calculation convertToModel(CalculationEntity entity);
}
