package sp.supportconnection.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor()
@Table(name="SUPPORT")
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="support_id")
    private Long id;

    private String name;

    private String category;

    private float rate;

    private String site;

    @Column(name="is_local")
    private int isLocal;

    private String type;

    private int amount;

    @OneToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToOne
    @JoinColumn(name = "support_detail_id")
    private SupportDetail supportDetail;

}