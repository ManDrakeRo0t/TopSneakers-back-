package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "attribute")
@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany( fetch = FetchType.EAGER)
    private List<AttributesValues> attributesValues;



    public Attribute() {
    }
}
