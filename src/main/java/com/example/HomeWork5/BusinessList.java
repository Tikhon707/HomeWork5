package com.example.HomeWork5;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class BusinessList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    public String name;

    @OneToMany(mappedBy = "businessList", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<Task> tasks;

    public BusinessList(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public BusinessList(){
        this.name = "unnamedBusinessList";
        this.tasks = new ArrayList<>();
    }
}
