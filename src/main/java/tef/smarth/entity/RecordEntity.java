package tef.smarth.entity;


import lombok.*;
import tef.smarth.entity.enums.ParameterType;
import tef.smarth.entity.enums.RecordType;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
@Table(name = "records")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_record")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "record_type")
    @Enumerated(EnumType.STRING)
    private RecordType recordType;

    @Column(name = "parameter_type")
    @Enumerated(EnumType.STRING)
    private ParameterType parameterType;

    @Column(name = "measurement")
    private String measurement;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public String getSummary() {
        return '\n' + name + ": " + value + measurement + " on " + date;
    }
}
