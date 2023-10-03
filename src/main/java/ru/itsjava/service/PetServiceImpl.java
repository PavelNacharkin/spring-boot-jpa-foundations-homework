package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Transactional(readOnly = true)
    @Override
    public void printAllPets() {
        List<Pet> petList = petRepository.findAll();
        System.out.println("Список питомцев : = " + petList.toString());
    }

    @Transactional
    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    @Override
    public Pet getPetByBreed(String breed) {
        return (Pet) petRepository.findByBreed(breed);
    }
}
