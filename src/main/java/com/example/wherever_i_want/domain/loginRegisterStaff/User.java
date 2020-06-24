package com.example.wherever_i_want.domain.loginRegisterStaff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "NICK")
    private String nick;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "AGE")
    private int age;
    @Column(name = "EMAIL")
    private String eMail;
    @Column(name = "EMAIL_PASSWORD")
    private String password;

    @OneToMany(
            targetEntity = LogIn.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<LogIn> logsIn = new ArrayList<>();
}
