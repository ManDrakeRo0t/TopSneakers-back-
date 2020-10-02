package ru.bogatov.VueApp.Entities;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String number;
    private String mail;
    private String password;
    private Boolean active;
    @Enumerated(value = EnumType.STRING)
    private Roles role;
    @OneToMany( fetch = FetchType.EAGER)
    private List<News> newsList;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Post> postList;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Busket> busketList;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Selling> sellingList;


    public User(){}



}
