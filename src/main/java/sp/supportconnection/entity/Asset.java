package sp.supportconnection.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name="support_deadline")
    private Date supportDeadline;

    @Column(name="annual_income")
    private int annualIncome;

    @Column(name="loan")
    private int loan;

    @Column(name="interest_rate")
    private float interestRate;

    @Column(name ="credit_rate")
    private int creditRate;

    public Asset(int myAsset, int supportRemain, Date supportDeadline, int annualIncome, int loan, float interestRate, int creditRate){
        this.myAsset = myAsset;
        this.supportRemain = supportRemain;
        this.supportDeadline = supportDeadline;
        this.annualIncome = annualIncome;
        this.loan = loan;
        this.interestRate = interestRate;
        this.creditRate = creditRate;
    }

}


