package com.cinema.repository;

import com.cinema.entity.Account;
import com.cinema.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByStateOrCountry(String state, String country);
    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int value);
    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole userRole);
    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int firstAge,int secondAge);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressContains(String pattern);
    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAge();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> getAccounts();
    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a where a.role = ?1")
    List<Account> getAdminAccounts(UserRole userRole);
    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age desc")
    List<Account> getAccountsWithAge();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < :age",nativeQuery = true)
    List<Account> getAccountsLowerThanAge(@Param("age") int age);
    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name,address,country like concat(%,?1,%) ",nativeQuery = true)
    List<Account> getContainingAccountsWithSpecificValue(String pattern);
    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < ?1",nativeQuery = true)
    List<Account> getAccountsAgeLowerThan(int age);

}
