package com.example.wherever_i_want.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NamedNativeQuery(
        name = "CityArtificialData.getByUserRequest",
        query = "select CITY_ID. * from cities_artificial_data",
        resultClass = CityArtificialData.class
)

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name= "CITIES_ARTIFICIAL_DATA")
@NoArgsConstructor
@AllArgsConstructor
public class CityArtificialData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GENERAL_ID")
    private int general_id;
    @Column(name = "CITY_ID")
    @JsonProperty("id")
    private String id;
    @Column(name="CITY_NAME")
    private String name;
    @Column(name="COUNTRY_CODE")
    private String countryCode;
    @Column(name = "JANUARY")
    private int JANUARY;
    @Column(name = "FEBRUARY")
    private int FEBRUARY;
    @Column(name = "MARCH")
    private int MARCH;
    @Column(name = "APRIL")
    private int APRIL;
    @Column(name = "MAY")
    private int MAY;
    @Column(name = "JUNE")
    private int JUNE;
    @Column(name = "JULY")
    private int JULY;
    @Column(name = "AUGUST")
    private int AUGUST;
    @Column(name = "SEPTEMBER")
    private int SEPTEMBER;
    @Column(name = "OCTOBER")
    private int OCTOBER;
    @Column(name = "NOVEMBER")
    private int NOVEMBER;
    @Column(name = "DECEMBER")
    private int DECEMBER;
}
