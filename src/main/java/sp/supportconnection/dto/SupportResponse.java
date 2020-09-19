package sp.supportconnection.dto;

import lombok.Data;


@Data
public class SupportResponse {
    private Long supportId;
    private String name;
    private String category;
    private float rate;
    private String site;
    private int isLocal;
    private String type;
    private int amount;
    private int reduceInterest;
}
