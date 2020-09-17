package sp.supportconnection.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Condition {
    @Id @GeneratedValue
    @Column(name="condition_id")
    private Long id;

    private String province;

    private String disrict;

    @Column(name="income_group")
    private int incomeGroup;

    @Column(name="annual_income")
    private int annualIncome;

    @Column(name="is_married")
    private boolean isMarried;

    @Column(name="have_child")
    private boolean haveChild;

    @Column(name="child_age")
    private int childAge;

    @Column(name="is_pregnant")
    private boolean isPregnant;

    private int occupation;

    @Column(name="is_temporary")
    private boolean isTemporary;

    @Column(name="is_unemployed")
    private boolean isUnemployed;

    @Column(name="business_type")
    private String businessType;

    @Column(name="business_scale")
    private int businessScale;

    @Column(name="annual_sale")
    private int anuualSale;

}
