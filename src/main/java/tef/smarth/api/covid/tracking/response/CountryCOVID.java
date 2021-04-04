package tef.smarth.api.covid.tracking.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CountryCOVID {

    @JsonProperty("Active Cases_text")
    public String activeCases_text;
    @JsonProperty("Country_text")
    public String country_text;
    @JsonProperty("Last Update")
    public String lastUpdate;
    @JsonProperty("New Cases_text")
    public String newCases_text;
    @JsonProperty("New Deaths_text")
    public String newDeaths_text;
    @JsonProperty("Total Cases_text")
    public String totalCases_text;
    @JsonProperty("Total Deaths_text")
    public String totalDeaths_text;
    @JsonProperty("Total Recovered_text")
    public String totalRecovered_text;

    @Override
    public String toString() {
        return "\n{" +
                "\nactiveCases_text='" + activeCases_text + '\'' +
                ", \ncountry_text='" + country_text + '\'' +
                ", \nlastUpdate='" + lastUpdate + '\'' +
                ", \nnewCases_text='" + newCases_text + '\'' +
                ", \nnewDeaths_text='" + newDeaths_text + '\'' +
                ", \ntotalCases_text='" + totalCases_text + '\'' +
                ", \ntotalDeaths_text='" + totalDeaths_text + '\'' +
                ", \ntotalRecovered_text='" + totalRecovered_text + '\'' +
                '}';
    }
}
