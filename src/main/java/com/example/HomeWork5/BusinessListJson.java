package com.example.HomeWork5;

import lombok.Data;

import java.util.List;

@Data
public class BusinessListJson {
    public String name;
    public List<String> events;

    public BusinessListJson(String name, List<String> events){
        this.name = name;
        this.events = events;
    }
}
