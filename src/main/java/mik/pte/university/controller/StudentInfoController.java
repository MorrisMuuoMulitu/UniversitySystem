package mik.pte.university.controller;


import mik.pte.university.domain.StudentInfo;
import mik.pte.university.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController implements RestController<StudentInfo>{

    private final StudentInfoService studentInfoService;

    @Autowired
    public StudentInfoController(StudentInfoService studentInfoService){
        this.studentInfoService=studentInfoService;
    }
    @GetMapping("/all")
    String getStudentInfo(Model model){
        model.addAttribute("studentInfo",studentInfoService.findAll());
        return "studentInfo";
    }

    @Override
    public String getAll(Model model) {
        model.addAttribute("studentInfo", studentInfoService.findAll());
        return "studentInfo";
    }
}
