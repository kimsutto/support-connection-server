package sp.supportconnection.dto;


import lombok.Data;

import java.util.Date;

@Data
public class GetSupportRemainResponse {
    private String name;
    private int supportRemain;
    private Date supportDeadline;
}
