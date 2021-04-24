package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.model.Record;
import tef.smarth.model.User;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    RecordEntity convertToEntity (Record model);

    Record convertToModel(RecordEntity entity);
}
