package ru.itsjava.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    private  int age;

    @ManyToOne(targetEntity = Pet.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", nullable = true)
    private  Pet pet;
}