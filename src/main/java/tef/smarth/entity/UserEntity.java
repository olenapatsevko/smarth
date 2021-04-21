package tef.smarth.entity;

import lombok.*;
import tef.smarth.entity.enums.BloodGroup;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

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
    private Date birthday;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @Column(name = "email", unique = true)
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
    private Set<DiseaseEntity> diseases;

    @Column(name = "records")
    @OneToMany(mappedBy = "user")
    private Set<RecordEntity> records;

    @Column(name = "hip")
    private int hip;

    @Column(name = "waist")
    private int waist;

    @Column(name = "calculations")
    @OneToMany(mappedBy = "user")
    private Set<CalculationEntity> calculations;
    @Transient
    private String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "users_has_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<RoleEntity> roles = new HashSet<>();
}