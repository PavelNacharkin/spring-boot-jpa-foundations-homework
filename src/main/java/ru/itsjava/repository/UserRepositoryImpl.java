package ru.itsjava.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void insert(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteById(long id) {
        User userById = entityManager.find(User.class, id);
        if (userById != null) {
            userById.setPet(null);
            entityManager.merge(userById);
            entityManager.flush();
            entityManager.remove(userById);
        } else {
            System.out.println("Пользователь не найден");
        }
    }
}
