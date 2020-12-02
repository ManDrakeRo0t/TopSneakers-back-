package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private BrandName brandName;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
    private Float price;
    private Integer count;
    private Calendar creationDate;
    private Integer sale;
    @OneToMany( fetch = FetchType.EAGER)
    private List<AttributesValues> attributesValues;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    private PicturesSet pictures;
    private boolean status;  //todo продумать логику статуса
    @Transient
    private String brand;


    public Product() {
    }

    public String getDateFormat(){
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        return fmt.format(creationDate.getTime());
    }

    public String getPriceString(){
        return price.toString();
    }
}
