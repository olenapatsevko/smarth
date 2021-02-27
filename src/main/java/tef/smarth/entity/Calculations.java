package tef.smarth.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "calculations")
public class Calculations {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_record")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private double value;

    @Column(name = "meaning")
    private String meaning;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
