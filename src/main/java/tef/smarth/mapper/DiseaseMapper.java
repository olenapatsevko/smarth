package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.DiseaseEntity;
import tef.smarth.entity.RecordEntity;
import tef.smarth.model.Disease;
import tef.smarth.model.Record;

@Mapper(componentModel = "spring")
public interface DiseaseMapper {

    DiseaseEntity convertToEntity (Disease model);

    Disease convertToModel(DiseaseEntity entity);
}
