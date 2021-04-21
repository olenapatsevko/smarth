package tef.smarth.entity;


import lombok.*;
import tef.smarth.entity.enums.CalculationType;
import tef.smarth.entity.enums.Measurements;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calculations")
public class CalculationEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_record")
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private CalculationType name;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private double value;

    @Column(name = "measurement")
    private Measurements measurement;

    @Column(name = "meaning")
    private String meaning;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
