package com.cinema.repository;

import com.cinema.entity.Movie;
import com.cinema.entity.Ticket;
import com.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    List<Ticket> countTicketByUserAccount(User user);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    List<Ticket> countTicketByMovieCinemaMovie(Movie movie);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDate localDate1,LocalDate localDate2);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t inner join User u on t.id=u.id where u.username =?1")
    List<Ticket> getTicketsByUserAccount(User user);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> getTicketsByDateTimeBetween(LocalDate localDate1,LocalDate localDate2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(id) FROM ticket",nativeQuery = true)
    Ticket getCountsOfTickets();
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count(id) FROM ticket where date_time=?1",nativeQuery = true)
    List<Ticket> getCountsOfTicketsByDateTime(LocalDate localDate);
    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT distinct Movie.name from Ticket inner join Movie on Movie.id=Ticket.id",nativeQuery = true)
    List<Ticket> getDistinctByMovie();
    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM Ticket inner join User on User.id=Ticket.id where User.email= ?1",nativeQuery = true)
    List<Ticket> getTicketsByEmail(String email);
    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> getTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

}
