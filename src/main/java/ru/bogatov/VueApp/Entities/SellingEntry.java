package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "selling_entry")
public class SellingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer count;
    private Float price;
    private Integer sale;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "selling_id")
    private Selling selling;


    public SellingEntry() {
    }

}
