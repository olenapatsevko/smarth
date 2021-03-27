package tef.smarth.api.bmi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Height{
    public String m;
    public String cm;
    public String in;
    @JsonProperty("ft-in")
    public String ftIn;
}
