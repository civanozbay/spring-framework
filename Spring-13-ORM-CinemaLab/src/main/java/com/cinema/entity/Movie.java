package com.cinema.entity;

import com.cinema.enums.State;
import com.cinema.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private int duration;
    private String summary;

    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinema;

    @ManyToMany(mappedBy = "movie")
    private List<Genre> genre;
}
