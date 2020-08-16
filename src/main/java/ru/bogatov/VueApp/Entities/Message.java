package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;


}
