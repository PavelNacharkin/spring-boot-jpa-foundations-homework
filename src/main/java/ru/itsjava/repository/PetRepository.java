package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetRepository {
    List<Pet> findAll();

    Pet getById(long id);
}
