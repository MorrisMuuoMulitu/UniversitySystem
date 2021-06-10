package mik.pte.university.controller;

import mik.pte.university.domain.Subject;
import mik.pte.university.repository.SubjectRepository;
import mik.pte.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
public class SubjectController implements RestController<Subject> {

    private final SubjectService subjectService;


    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }

//    @GetMapping("/all")
//    String getSubject(Model model){
//        model.addAttribute("subject",subjectService.findAll());
//        return "subject";
//    }


    @Override
    public String getAll(Model model) {
        model.addAttribute("subject",subjectService.findAll());
        return "subject";
    }
}
