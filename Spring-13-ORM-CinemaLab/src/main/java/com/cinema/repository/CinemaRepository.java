package com.cinema.repository;

import com.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //




    //Write a derived query to get cinema with a specific name
    Cinema findByName(String name);
    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String pattern);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocationCountry(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name,String sponsorName);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c where c.id= ?1")
    Cinema getCinemaById(@Param("id") Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join location l "+
                    "on c.location_id=l.location_id where l.country= ?1",nativeQuery = true)
    List<Cinema> getCinemasByLocationCountry(@Param("locationCountry") String locationCountry);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinemas where name ILIKE concat('%',?1,'%')" +
                    "OR sponsored_name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Cinema> getCinemasContainsNameOrSponsoredName(@Param("pattern") String pattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * from cinema order by name",nativeQuery = true)
    List<Cinema> getAllCinemasByName(String name);
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct sponsored_name from cinema ",nativeQuery = true)
    List<String> getCinemaByDistinctWithSponsoredName(String name);

}
