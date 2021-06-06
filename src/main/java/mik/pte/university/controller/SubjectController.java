package mik.pte.university.controller;

import mik.pte.university.repository.SubjectRepository;
import mik.pte.university.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;


    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }

    @GetMapping("/all")
    String getSubject(Model model){
        model.addAttribute("subject",subjectService.findAll());
        return "subject";
    }


}
