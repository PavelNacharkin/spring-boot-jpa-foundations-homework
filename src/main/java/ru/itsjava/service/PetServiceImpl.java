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
}
