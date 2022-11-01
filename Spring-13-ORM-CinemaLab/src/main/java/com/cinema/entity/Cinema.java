package com.cinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cinema{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String sponsoredName;

    @OneToMany(mappedBy = "cinema")
    private List<MovieCinema> movieCinema;

    @ManyToOne
    private Location location;

}
