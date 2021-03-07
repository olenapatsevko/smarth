package tef.smarth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer id;

    @Column(name = "name_role")
    private String name;

    @ManyToMany
    @JoinTable(name = "persons_has_roles",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    private Set<UserEntity> userEntities = new HashSet<>();

    public RoleEntity() {
    }

    public RoleEntity(Integer id, String name) {
            this.id = id;
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity role = (RoleEntity) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}










//    @Transient
//    static Role defaultRoleByRegistrationInstance;
//
//    public static Role getDefaultRoleInstance() {
//        if (defaultRoleByRegistrationInstance == null) {
//            synchronized (Role.class) {
//                if (defaultRoleByRegistrationInstance == null) {
//                    defaultRoleByRegistrationInstance = new Role();
//                    defaultRoleByRegistrationInstance.setId(0L);
//                    defaultRoleByRegistrationInstance.setName("CLIENT");
//                }
//            }
//        }
//        return defaultRoleByRegistrationInstance;
//    }

