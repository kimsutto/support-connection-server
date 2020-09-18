package sp.supportconnection.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="ASSET")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asset_id")
    private Long id;

    @Column(name="my_asset")
    private int myAsset;

    @Column(name="support_remain")
    private int supportRemain;

    public Asset(int myAsset, int supportRemain){
        this.myAsset = myAsset;
        this.supportRemain = supportRemain;
    }

}


