package ru.bogatov.VueApp.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "messages")
public class Message implements Comparable<Message>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;

    public Message() {
    }

    @Override
    public int compareTo(Message o) {
        return this.id - o.getId();
    }
}
