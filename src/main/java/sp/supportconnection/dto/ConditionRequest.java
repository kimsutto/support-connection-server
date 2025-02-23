package sp.supportconnection.dto;

import lombok.Data;

@Data
public class ConditionRequest{
    private Long userId;
    private String province;
    private String district;
    private int minAge;
    private int maxAge;
    private int incomeGroup;
    private int annualIncome;
    private int isMarried;
    private int haveChild;
    private int minChildAge;
    private int maxChildAge;
    private int isPregnant;
    private int occupation;
    private int isTemporary;
    private int isUnemployed;
    private String businessType;
    private int businessScale;
    private int annualSale;
}