package sp.supportconnection.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReduceFinanceAssetResponse {
    private String name;
    private float interestRate;
    private int creditRate;
    private int currentInterest;
    private int reduceInterest;
    private int annualIncome;
    private int myAsset;
    private List<SupportResponse> supports;

}
