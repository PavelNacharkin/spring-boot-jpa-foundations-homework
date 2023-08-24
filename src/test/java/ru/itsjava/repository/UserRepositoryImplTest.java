package ru.itsjava.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Import(UserRepositoryImpl.class)
public class UserRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldHaveCorrectGetById() {
        var expectedUser = entityManager.find(User.class, 1L);
        var actualUser = userRepository.getById(1L);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void shouldHaveCorrectInsert() {
        var insertUser = new User(4L, "Dmitry", 45, new Pet(2, "Siamese"));
        userRepository.insert(insertUser);
        var actualUser = userRepository.getById(4L);

        assertEquals(insertUser, actualUser);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        var updateUser = userRepository.getById(2L);
        updateUser.setName("Stanislav");
        userRepository.update(updateUser);
        var actualUser = userRepository.getById(2L);

        assertEquals("Stanislav", actualUser.getName());
    }

    @Test
    public void shouldHaveCorrectDeleteById() {
        userRepository.deleteById(3L);
        var deletedUser = userRepository.getById(3L);

        assertNull(deletedUser);
    }
}
