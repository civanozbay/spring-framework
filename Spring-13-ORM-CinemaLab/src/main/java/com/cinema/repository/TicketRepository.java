package com.cinema.repository;

import com.cinema.entity.Movie;
import com.cinema.entity.Ticket;
import com.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long id);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime localDate1, LocalDateTime localDate2);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t where t.userAccount.id= ?1")
    List<Ticket> getTicketsByUserAccount(Long id);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> getTicketsByDateTimeBetween(LocalDate localDate1,LocalDate localDate2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(*) FROM ticket where user_account_id = ?1",nativeQuery = true)
    Integer getCountsOfTickets(Long userId);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count(*) FROM ticket where user_account_id = ?1 and date_time between ?2 and ?3",nativeQuery = true)
    List<Ticket> getCountsOfTicketsByDateTime(Long userId,LocalDate localDate1,LocalDate localDate2);
    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT distinct(m.name) from Ticket t join movie_cinema mc on mc.id=t.movie_cinema_id" +
            "join movie m on m.id=mc.movie_id",nativeQuery = true)
    List<String> getDistinctMovieNames();
    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM Ticket t join user_account ua on ua.id=t.user_account_id where ua.email= ?1",nativeQuery = true)
    List<Ticket> getTicketsByEmail(String email);
    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> getAllTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON " +
            "t.user_account_id = ua.id JOIN account_details ad ON" +
            " ad.id = ua.account_details_id JOIN movie_cinema mc ON " +
            " t.movie_cinema_id = mc.id JOIN movie m" +
            " ON mc.movie_id = m.id" +
            " WHERE ua.username ILIKE concat('%',?1,'%') OR ad.name  ILIKE concat('%',?1,'%') OR m.name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(@Param("searchCriteria") String searchCriteria);
}
