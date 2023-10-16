package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;
import ru.itsjava.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;

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

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    @Transactional
    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }
    @Transactional
    @Override
    public void deletePet(Pet pet) {
        userRepository.deleteAllByPet(pet);
        petRepository.delete(pet);

    }
}
