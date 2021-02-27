package tef.smarth.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tef.smarth.entity.enums.BloodGroup;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "persons")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private boolean isMan;

    @Column(name = "age")
    private int age;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @Column(name = "email")
    private String email;

    @Column(name = "blood_group")
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @Column(name = "diseases")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "User_Diseases",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_disease")}
    )
    private Set<Disease> diseases;

    @Column(name = "records")
    @OneToMany(mappedBy = "user")
    private Set<Record> records;


    @Column(name = "calculations")
    @OneToMany(mappedBy = "user")
    private Set<Calculations> calculations;
    @Transient
    private String passwordConfirm;

}