package sp.supportconnection.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asset_id")
    private Long id;

    @Column(name="my_asset")
    private int myAsset;

    @Column(name="support_remain")
    private int supportRemain;
}
