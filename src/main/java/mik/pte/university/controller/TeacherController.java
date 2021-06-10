package mik.pte.university.controller;

import mik.pte.university.domain.Teacher;
import mik.pte.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController implements mik.pte.university.controller.RestController<Teacher> {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

   // @RequestMapping("/all")
//    String getTeacher(Model model){
//        model.addAttribute("teacher", teacherService.findAll());
//        return "teacher";
//    }


    public ModelAndView teacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("teacher");
        return modelAndView;
    }

    @Override
    public String getAll(Model model) {
        model.addAttribute("teacher", teacherService.findAll());
        return "teacher";
    }
}
