package com.cinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String country;
    private String city;
    private String state;
    private int postalCode;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Cinema> cinemaList;
}
