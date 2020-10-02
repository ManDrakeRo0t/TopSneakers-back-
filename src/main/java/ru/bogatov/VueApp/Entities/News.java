package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "news")
@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String tag;
    private Date creationDate;
    private String content;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    private PicturesSet picures;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public News() {
    }
}
