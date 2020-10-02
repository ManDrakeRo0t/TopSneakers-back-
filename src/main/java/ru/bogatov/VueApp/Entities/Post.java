package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String text;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    private PicturesSet picures;

    public Post() {
    }
}
