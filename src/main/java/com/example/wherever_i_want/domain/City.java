package com.example.wherever_i_want.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name= "CITIES")
@NoArgsConstructor
@AllArgsConstructor
public class City {

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
}
