package ru.itsjava.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(PetRepositoryImpl.class)
public class PetRepositoryImplTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PetRepository petRepository;


    @Test
    public void shouldHaveCorrectFindById() {
        var expectedPet = entityManager.find(Pet.class, 1L);
        var actualPet = petRepository.getById(1L);

        assertEquals(expectedPet, actualPet);
    }

    @Test
    public void shouldHaveCorrectFindAll() {
        var expectedPets = entityManager.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
        var actualPets = petRepository.findAll();

        assertEquals(expectedPets, actualPets);
    }
}