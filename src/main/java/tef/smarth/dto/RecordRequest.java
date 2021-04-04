package tef.smarth.dto;

import lombok.Data;

@Data
public class RecordRequest {

    private String leukocytes;
    private String hemoglobin;
    private String hemoprotein;
    private String thrombocytes;
    private String homa;

    private String email;
}
