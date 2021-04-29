package tef.smarth.model;


import lombok.*;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;

import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class Record {

    private Integer id;

    private String name;

    private String value;

    private RecordType recordType;

    private ParameterType parameterType;

    private String measurement;

    private Date date;

    private User user;

    public String getSummary() {
        return '\n' + name + ": " + value + (measurement == null ? "" : measurement) + " on " + date;
    }
}
