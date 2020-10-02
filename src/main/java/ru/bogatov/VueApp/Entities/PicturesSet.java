package ru.bogatov.VueApp.Entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pictures_set")
public class PicturesSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany( fetch = FetchType.EAGER)
    private List<PicturesEntry> pictures;
    @OneToMany( fetch = FetchType.EAGER)
    private List<News> newsRoot;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Post> postRoot;

    public PicturesSet() {
    }
}
