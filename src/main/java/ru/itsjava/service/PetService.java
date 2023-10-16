package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetService {
    void printAllPets();

    void createPet(Pet pet);

    Pet getPetById(long id);

    Pet getPetByBreed(String breed);

    List<Pet> getAllPets();

    void updatePet(Pet pet);

    void deletePet(Pet pet);
}
