package ru.bogatov.VueApp.Entities;

import lombok.Data;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
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
