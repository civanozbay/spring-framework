package com.cinema.repository;

import com.cinema.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("SELECT g from Genre g")
    List<Genre> getGenres();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "select * from genre where name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Genre> getGenresContainName(@Param("name")String name);
}
