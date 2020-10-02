package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "deliver_punct")
public class DeliverPunct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;
    private float longitude;
    private float latitude;
    private String address;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Selling> sellingList;

    public DeliverPunct() {
    }
}
