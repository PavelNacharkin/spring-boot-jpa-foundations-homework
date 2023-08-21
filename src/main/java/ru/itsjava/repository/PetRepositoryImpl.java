package ru.itsjava.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

import java.util.List;

@Transactional
@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
    }

    @Override
    public Pet getById(long id) {
        return entityManager.find(Pet.class, id);
    }
}
