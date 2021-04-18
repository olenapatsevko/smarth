package tef.smarth.dto;

import lombok.Data;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;

import java.sql.Date;

@Data
public class Record {

    private String name;

    private String value;

    private RecordType recordType;

    private ParameterType parameterType;

    private String measurement;

    private Date date;

}
