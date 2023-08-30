package ru.itsjava.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.itsjava.domain.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldHaveCorrectDeleteById() {
        userRepository.deleteById(3L);
        Optional<User> deletedUser = userRepository.findById(3L);

        assertFalse(deletedUser.isPresent());
    }
}
