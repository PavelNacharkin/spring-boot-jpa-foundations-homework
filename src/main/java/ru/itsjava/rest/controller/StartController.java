package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itsjava.rest.dto.PetDto;

@Controller
@RequiredArgsConstructor
public class StartController {
    @GetMapping("/")
    public String getPage() {

        return "start-page";
    }
}
