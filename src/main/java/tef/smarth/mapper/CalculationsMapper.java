package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.CalculationEntity;
import tef.smarth.model.Calculation;

@Mapper(componentModel = "spring")
public interface CalculationsMapper extends Mapping<Calculation, CalculationEntity>{
}
