package ru.itsjava.service;

public interface UserService {
    void printListOfUsersEqualTo(int count);

    void changeName(Long id, String newName);


}
