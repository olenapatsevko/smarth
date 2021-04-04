package tef.smarth.dto;

import lombok.Data;
import tef.smarth.entity.UserEntity;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class Record {

    private String name;

    private String value;

    private RecordType recordType;

    private ParameterType parameterType;

    private String measurement;

    private Date date;

}
