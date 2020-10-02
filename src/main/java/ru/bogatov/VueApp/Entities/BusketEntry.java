package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "busket_entry")
public class BusketEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer count;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "busket_id")
    private Busket busket;

    public BusketEntry() {
    }
}
