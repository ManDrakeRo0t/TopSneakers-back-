package ru.bogatov.VueApp.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "selling")
public class Selling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date deliverDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "punct_id")
    private DeliverPunct deliverPunct;
    @OneToMany( fetch = FetchType.EAGER)
    private List<SellingEntry> sellingEntrySet;
    private String details;
    private Date payDate;
    boolean isAccepted;
    boolean isPayed;
    boolean deleted;


    public float calculatePrice(){
        float price = 0;
        for(SellingEntry entry : sellingEntrySet){
            price += entry.getPrice() * entry.getCount() * (1 - ((float)entry.getSale() / 100));
        }
        return price;
    }


    @Transient
    String address;

    public Selling() {
    }
}
