package ru.itsjava.service;


import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.util.List;

public interface UserService {
    void printListOfUsersEqualTo(int count);

    void changeName(Long id, String newName);

    List<User> getAllUsers();

    void createUser(User user);
    User getUserById(long id);

}
