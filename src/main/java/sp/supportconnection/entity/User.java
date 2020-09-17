package sp.supportconnection.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String name;

    private String agency;

    @Column(name="phone_number")
    private String phoneNumber;

    private int age;

    @OneToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;

}
