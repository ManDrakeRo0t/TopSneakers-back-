package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attribute_values")
public class AttributesValues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    private String stringValue;

    public AttributesValues() {
    }
}
