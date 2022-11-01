package com.cinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user_account")
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String username;

    @OneToOne
    private AccountDetails accountDetails;

//    @OneToMany(mappedBy = "userAccount")
//    private List<Ticket> ticket;
}
