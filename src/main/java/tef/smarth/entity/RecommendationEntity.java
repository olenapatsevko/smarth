package tef.smarth.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "recommendations")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_recommendations")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;
}
