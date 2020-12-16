package ru.bogatov.VueApp.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Data {
    List<String> labels = new ArrayList<>();
    DataSet datasets = new DataSet();

}
