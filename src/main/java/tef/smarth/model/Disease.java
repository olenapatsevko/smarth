package tef.smarth.model;


import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

    private Integer id;

    private String name;

    private Set<User> users;
}
