package com.example.HomeWork5;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {

    @Id
    private Long Id;

    private String task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private BusinessList BList;
}
