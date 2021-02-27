package tef.smarth.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


@ToString
@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_report")
    private long id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "completion_time")
    private Date completionTime;

    @Column(name = "total_amount_of_property")
    private long totalAmountOfProperty;

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_user")
    private User person;

    @Column(name = "is_accepted")
    private boolean accepted;



}
