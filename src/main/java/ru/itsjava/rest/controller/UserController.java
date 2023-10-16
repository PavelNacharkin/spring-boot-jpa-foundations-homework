package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.domain.User;
import ru.itsjava.rest.dto.UserDto;
import ru.itsjava.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("user/{id}")
    public String getPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", UserDto.toDto(userService.getUserById(id)));
        return "get-user-page";
    }
    @GetMapping("/users")
    public String usersPage(Model model) {
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> userDto = new ArrayList<>();

        for (User user : allUsers) {
            userDto.add(UserDto.toDto(user));
        }
        model.addAttribute("users", userDto);
        return "users-page";
    }
    @GetMapping("users/add")
    public String addPage() {
        return "add-user-page";
    }

    @PostMapping("users/add")
    public String afterAddPage(UserDto userDto) {
        userService.createUser(UserDto.fromDto(userDto));
        return "redirect:/";
    }





}
