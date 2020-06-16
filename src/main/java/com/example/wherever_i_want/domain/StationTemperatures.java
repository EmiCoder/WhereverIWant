package com.example.wherever_i_want.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name= "STATIONS_TEMPERATURES")
@NoArgsConstructor
@AllArgsConstructor
public class StationTemperatures {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "CITY_ID")
    private String cityId;
    @Column(name = "JANUARY")
    private String JANUARY;
    @Column(name = "FEBRUARY")
    private String FEBRUARY;
    @Column(name = "MARCH")
    private String MARCH;
    @Column(name = "APRIL")
    private String APRIL;
    @Column(name = "MAY")
    private String MAY;
    @Column(name = "JUNE")
    private String JUNE;
    @Column(name = "JULY")
    private String JULY;
    @Column(name = "AUGUST")
    private String AUGUST;
    @Column(name = "SEPTEMBER")
    private String SEPTEMBER;
    @Column(name = "OCTOBER")
    private String OCTOBER;
    @Column(name = "NOVEMBER")
    private String NOVEMBER;
    @Column(name = "DECEMBER")
    private String DECEMBER;

}
