package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String brand;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
    private Integer price;
    private Integer count;
    private Integer sale;
    @OneToMany( fetch = FetchType.EAGER)
    private List<AttributesValues> attributesValues;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    private PicturesSet pictures;

    public Product() {
    }
}
