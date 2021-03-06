package com.example.wherever_i_want.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureDto {

    @JsonProperty("JAN")
    private String JAN;
    @JsonProperty("FEB")
    private String FEB;
    @JsonProperty("MAR")
    private String MAR;
    @JsonProperty("APR")
    private String APR;
    @JsonProperty("MAY")
    private String MAY;
    @JsonProperty("JUN")
    private String JUN;
    @JsonProperty("JUL")
    private String JUL;
    @JsonProperty("AUG")
    private String AUG;
    @JsonProperty("SEP")
    private String SEP;
    @JsonProperty("OCT")
    private String OCT;
    @JsonProperty("NOV")
    private String NOV;
    @JsonProperty("DEC")
    private String DEC;
}
