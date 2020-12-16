package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name ="cities")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany( fetch = FetchType.EAGER)
    private Set<DeliverPunct> deliverPuncts;

    public City() {
    }
}
