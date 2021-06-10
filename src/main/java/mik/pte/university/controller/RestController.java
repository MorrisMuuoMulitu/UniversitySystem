package mik.pte.university.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.List;

public interface RestController<T extends Serializable> {

    @GetMapping("/display")
    String getAll(Model model);
}
