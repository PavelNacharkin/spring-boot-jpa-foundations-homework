package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Pet;

@AllArgsConstructor
@Data
public class PetDto {
    private String id;
    private String breed;

    public static Pet fromDto(PetDto petDto){
        if (petDto.id == null){
            petDto.id = "0";
        }
        return new Pet(Long.parseLong(petDto.id), petDto.breed);
    }

    public static PetDto toDto(Pet pet) {
        String id = String.valueOf(pet.getId());
        String breed = pet.getBreed();

        return new PetDto(id, breed);
    }

}