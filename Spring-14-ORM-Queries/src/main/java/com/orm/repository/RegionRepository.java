package com.orm.repository;

import com.orm.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    // display all regions in Canada
    List<Region> findByCountry(String country); // select * from region where country= bla bla..

    // display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    // display all regions with country name includes 'United'
    List<Region> findByCountryContains(String country);

    //display all regions with country name includes 'Asia' in order
    List<Region> findByCountryContainsOrderByRegion(String country);

    //display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);
}
