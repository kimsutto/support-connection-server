package sp.supportconnection.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor()
@Table(name="CONDITIONS")
public class Condition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="condition_id")
    private Long id;

    private String province;

    private String district;

    @Column(name="min_age")
    private int minAge;

    @Column(name="max_age")
    private  int maxAge;

    @Column(name="income_group")
    private int incomeGroup;

    @Column(name="annual_income")
    private int annualIncome;

    @Column(name="is_married")
    private int isMarried;

    @Column(name="have_child")
    private int haveChild;

    @Column(name="min_child_age")
    private int minChildAge;

    @Column(name="max_child_age")
    private int maxChildAge;

    @Column(name="is_pregnant")
    private int isPregnant;

    private int occupation;

    @Column(name="is_temporary")
    private int isTemporary;

    @Column(name="is_unemployed")
    private int isUnemployed;

    @Column(name="business_type")
    private String businessType;

    @Column(name="business_scale")
    private int businessScale;

    @Column(name="annual_sale")
    private Integer annualSale;

}
