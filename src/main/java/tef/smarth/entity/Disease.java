package tef.smarth.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "diseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_disease")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "diseases")
    private Set<User> users;
}
