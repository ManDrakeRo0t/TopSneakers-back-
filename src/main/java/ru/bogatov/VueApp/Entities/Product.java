package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private BrandName brand;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
    private Float price;
    private Integer count;
    private Date creationDate;
    private Integer sale;
    @OneToMany( fetch = FetchType.EAGER)
    private List<AttributesValues> attributesValues;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    private PicturesSet pictures;
    private Boolean status;

    public Product() {
    }
}
