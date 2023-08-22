package ru.itsjava;

import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.PetRepository;
import ru.itsjava.repository.UserRepository;


import java.sql.SQLException;


@Transactional
@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);

        PetRepository petRepository = context.getBean(PetRepository.class);

        Pet petById = petRepository.getById(2L);

        System.out.println("petById = " + petById);
        System.out.println("petRepository.findAll() = " + petRepository.findAll());


        UserRepository userRepository = context.getBean(UserRepository.class);

        System.out.println("userRepository.getById(1L) = " + userRepository.getById(1L));


        User insertUser = new User(4L, "Oleg", 45, petById);
        userRepository.insert(insertUser);
        System.out.println("userRepository.getById(4L) = " + userRepository.getById(4L));


        insertUser.setName(" Oleg Popov");
        userRepository.update(insertUser);
        System.out.println("userRepository.getById(4L) = " + userRepository.getById(4L));

        userRepository.deleteById(4L);
        System.out.println("userRepository.getById(4L) = " + userRepository.getById(4L));

        userRepository.deleteById(5L);
        System.out.println("userRepository.getById(5L) = " + userRepository.getById(5L));

    }
}
