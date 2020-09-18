package sp.supportconnection.controller;

import lombok.Data;

@Data
public class ConditionRequest{
    private Long userId;
    private String province;
    private String district;
    private int incomeGroup;
    private int annualIncome;
    private int isMarried;
    private int haveChild;
    private int childAge;
    private int isPregnant;
    private int occupation;
    private int isTemporary;
    private int isUnemployed;
    private String businessType;
    private int businessScale;
    private int annualSale;
}