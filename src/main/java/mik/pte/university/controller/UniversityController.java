package mik.pte.university.controller;

import mik.pte.university.domain.University;
import mik.pte.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/university")
public class UniversityController implements RestController<University>{

    private final UniversityService universityService;


    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

//    @GetMapping("/all")
//    String getTeacher(Model model){
//        model.addAttribute("university", universityService.findAll());
//        return "university";
//    }

    @Override
    public String getAll(Model model) {
        model.addAttribute("university", universityService.findAll());
        return "university";
    }
}
