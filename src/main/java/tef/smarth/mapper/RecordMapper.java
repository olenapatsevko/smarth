package tef.smarth.mapper;

import org.mapstruct.Mapper;
import tef.smarth.entity.RecordEntity;
import tef.smarth.model.Record;

@Mapper(componentModel = "spring")
public interface RecordMapper extends Mapping<Record, RecordEntity> {
}
