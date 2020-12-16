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
    @JoinColumn(name = "city_id")
    private City city;
    private float longitude;
    private float latitude;
    private String address;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Selling> sellingList;
    @Transient
    float[] coords = new float[2];

    public void perform(){
        coords[1] = longitude;
        coords[0] = latitude;
    }

    @Transient
    private String cityName;

    public DeliverPunct() {
    }
}
