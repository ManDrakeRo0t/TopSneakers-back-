package ru.bogatov.VueApp.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Table(name = "busket")
@Entity
public class Busket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany( fetch = FetchType.EAGER)
    private Set<BusketEntry> products;

    public Busket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Busket)) return false;
        Busket busket = (Busket) o;
        return id.equals(busket.id) &&
                Objects.equals(products, busket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }
}
