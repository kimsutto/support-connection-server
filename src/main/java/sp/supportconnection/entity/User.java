package sp.supportconnection.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor()
@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="username")
    private String name;

    private String agency;

    @Column(name="phone_number")
    private String phoneNumber;

    private int age;

    @Column(name="child_age")
    private int childAge;

    @OneToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @OneToOne
    @JoinColumn(name = "available_id")
    private AvailableSupport availableSupport;


    @ManyToMany
    @JoinTable(name="USER_SUPPORT", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name= "support_id"))
    private List<Support> supports = new ArrayList<Support>();


}
