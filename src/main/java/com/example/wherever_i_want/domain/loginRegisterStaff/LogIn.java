package com.example.wherever_i_want.domain.loginRegisterStaff;

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
@Table(name= "LOGS_IN")
public class LogIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "LOGIN_DATE")
    private String loginDate;
    @Column(name = "LOGIN_TIME")
    private String loginTime;
}
