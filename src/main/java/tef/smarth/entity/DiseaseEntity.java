package tef.smarth.entity;


import lombok.*;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diseases")
public class DiseaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_disease")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "diseases")
    private Set<UserEntity> users;
}
