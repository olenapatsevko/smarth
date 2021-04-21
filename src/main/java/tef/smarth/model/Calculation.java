package tef.smarth.model;


import lombok.*;
import tef.smarth.entity.enums.CalculationType;
import tef.smarth.entity.enums.Measurements;

import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {

    private Integer id;

    private CalculationType name;

    private Date date;

    private double value;

    private Measurements measurement;

    private String meaning;

    private User user;
}
