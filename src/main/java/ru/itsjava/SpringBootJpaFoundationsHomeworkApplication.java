package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.service.PetService;
import ru.itsjava.service.UserService;


import java.sql.SQLException;


@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);


    }
}
