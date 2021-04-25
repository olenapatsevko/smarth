package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.DiseaseEntity;
import tef.smarth.model.Disease;

@Mapper(componentModel = "spring")
public interface DiseaseMapper {

    DiseaseEntity convertToEntity (Disease model);

    Disease convertToModel(DiseaseEntity entity);
}
