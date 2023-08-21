package ru.itsjava;

import jakarta.transaction.Transactional;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.repository.PetRepository;


import java.sql.SQLException;


@Transactional
@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);

        PetRepository petRepository = context.getBean(PetRepository.class);
        System.out.println("petRepository.getById(1L) = " + petRepository.getById(2));
//        Console.main(args);

        System.out.println("petRepository.findAll() = " + petRepository.findAll());

    }
}
