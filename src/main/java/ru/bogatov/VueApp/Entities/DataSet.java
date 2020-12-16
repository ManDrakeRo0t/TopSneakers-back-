package ru.bogatov.VueApp.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class DataSet {
    public List<Integer> data = new ArrayList<>(10);
    public List<String> backgroundColor = new ArrayList<>(10);
}
