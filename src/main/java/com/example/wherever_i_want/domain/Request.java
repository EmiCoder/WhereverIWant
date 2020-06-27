package com.example.wherever_i_want.domain;

import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "REQUESTS")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "TEMPERATURE")
    private int temperature;
    @Column(name = "MTH")
    private String month;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "REQUEST_DATE")
    private String requestDate;
}
