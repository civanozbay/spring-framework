package com.orm.bootstrap;

import com.orm.entity.Car;
import com.orm.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1 = new Car("BMW","M5");
        Car c2 = new Car("TOYOTA","Corolla");
        Car c3 = new Car("HONDA","Civic");
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
