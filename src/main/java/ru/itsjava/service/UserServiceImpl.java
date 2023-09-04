package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public void printListOfUsersEqualTo(int count) {
        List<User> userList = new ArrayList<>();
        long id = 1;
        for (int i = 0; i < count; i++) {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                userList.add(user);
                id++;
            } else {
                System.out.println("Это все найденные пользователи");
            }
        }
        System.out.println("Список первых " + count + " пользователей = " + userList.toString());
    }

    @Transactional
    @Override
    public void changeName(Long id, String newName) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(newName);
            userRepository.save(user);
            System.out.println("Successfully saved!");
        } else {
            System.out.println("Пользователь не найден!");
        }
    }
}
