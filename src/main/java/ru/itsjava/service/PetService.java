package ru.itsjava.service;

import ru.itsjava.domain.Pet;

public interface PetService {
    void printAllPets();

    void createPet(Pet pet);

    Pet getPetById(long id);

    Pet getPetByBreed(String breed);
}
