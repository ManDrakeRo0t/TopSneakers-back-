package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pictures_entry")
public class PicturesEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private String source;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_set_id")
    private PicturesSet picturesSet;

    public PicturesEntry() {
    }
}
