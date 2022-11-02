package com.cinema.bootstrap;

import com.cinema.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("findByState: " + accountRepository.findByStateOrCountry("Kentucky","New York"));
        System.out.println("findByAgeLessThanEqual: " + accountRepository.findByAgeLessThanEqual(30));
        System.out.println("getAccounts : "+ accountRepository.getAccounts());
        System.out.println("getAccountsLowerThanAge : " + accountRepository.getAccountsLowerThanAge(30));
//        System.out.println("getContainingAccountsWithSpecificValue :  " + accountRepository.getContainingAccountsWithSpecificValue("a"));

    }
}
