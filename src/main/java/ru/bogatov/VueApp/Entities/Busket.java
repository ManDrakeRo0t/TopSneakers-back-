package ru.bogatov.VueApp.Entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "busket")
@Entity
public class Busket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany( fetch = FetchType.EAGER)
    private List<BusketEntry> products;

    public Busket() {
    }
}
