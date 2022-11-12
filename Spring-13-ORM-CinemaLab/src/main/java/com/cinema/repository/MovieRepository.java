package com.cinema.repository;

import com.cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);
    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal first,BigDecimal second);
    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> duration);
    //Write a derived query to list all movies with higher than a specific release date

    //Write a derived query to list all movies with a specific state and type

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    //Write a JPQL query that returns all movie names

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * from movie where name = ?1",nativeQuery = true)
    Movie getMovieByName(String name);
    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * from movie where price between :number1 and :number2",nativeQuery = true)
    List<Movie> getMoviesBySpecificRangePrices(@Param("number1") int number1,@Param("number2") int number2);
    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * from movie where exists duration < ?1",nativeQuery = true)
    List<Movie> getMoviesWithExistsDuration(int range);
    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select top 5 * from movie order by price desc",nativeQuery = true)
    List<Movie> getTop5MostExpensiveMovie();

}
