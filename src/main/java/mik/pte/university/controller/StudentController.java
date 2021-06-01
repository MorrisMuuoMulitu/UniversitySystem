package mik.pte.university.controller;


import mik.pte.university.domain.Student;
import mik.pte.university.domain.StudentInfo;
import mik.pte.university.domain.Teacher;
import mik.pte.university.service.StudentInfoService;
import mik.pte.university.service.StudentService;
import mik.pte.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;



    TeacherService teacherService;


    StudentInfoService studentInfoService;

    @Autowired
    public StudentController(StudentService studentService,TeacherService teacherService,StudentInfoService studentInfoService) {
        this.studentService = studentService;
        this.teacherService=teacherService;
        this.studentInfoService=studentInfoService;
    }

    @GetMapping("")
    String getStudent(Model model){
        model.addAttribute("student", studentService.findAll());
        return "students";
    }




    @GetMapping("/add")
    public String studentPageAdd(Model model) {
        model.addAttribute("stud", new Student());
        return "studentCreate";

    }
    @PostMapping("/add")
    public String studentAdd(@RequestParam String student_name,
                             @RequestParam String study_program,
                             @RequestParam String student_country) {



        Student s = new Student(student_name,study_program,student_country);
        studentService.saveObject(s);
        return "students";
    }



    @GetMapping("/morepage/{id}")
    public String morePage(@PathVariable(value = "id") Long id ,Model model) {


        Student student=studentService.findById(id);

        if (student!=null) {
            model.addAttribute("studentMore", student);
            return "studentMore";
        } else {
            return String.valueOf(HttpStatus.NOT_FOUND.value());
        }
    }


    @GetMapping("/editpage/{id}")
    public String editPage(@PathVariable(value = "id") Long id ,Model model) {


        Student student=studentService.findById(id);

        if (student!=null) {
            model.addAttribute("studentEdit", student);
            List<Teacher> teachers =  teacherService.findAll();
            model.addAttribute("teachers", teachers);
            return "studentEdit";
        } else {
            return String.valueOf(HttpStatus.NOT_FOUND.value());
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable(value = "id") Long id) {


        Student student=studentService.findById(id);

        if (student!=null) {
            studentService.deleteStudent(id);
            return "redirect:/student/";
        } else {
            return String.valueOf(HttpStatus.NOT_FOUND.value());
        }
    }

    @PostMapping("/update")
    public String updateStudent(
            @RequestParam Long id,
            @RequestParam String student_name, @RequestParam String study_program,
            @RequestParam String student_country,
            @RequestParam Teacher teacher) {
        Student student_0= studentService.findById(id);

        if (student_0!=null) {
            student_0.setStudent_name(student_name);
            student_0.setStudent_country(student_country);
            student_0.setStudy_program(study_program);
            student_0.setTeacher(teacher);
            studentService.saveObject(student_0);
            return "redirect:/student/";
        } else {
            return String.valueOf(HttpStatus.NOT_FOUND.value());
        }
    }

    @PostMapping("/updatemore")
    public String updateStudentMore(@ModelAttribute("studentMore") @Valid Student student,
                                    @RequestParam Long id
    ) {
        StudentInfo studentInfo=new StudentInfo(student.getStudentInfo().getNeptun_code(),student.getStudentInfo().getFinancial_status(),student.getStudentInfo().getActive_semesters());
        studentInfoService.saveObject(studentInfo);
        Student student_0 = studentService.findById(id);

        if (student!=null) {
            student_0.setStudentInfo(studentInfo);
            studentService.saveObject(student_0);
            return "redirect:/student/";
        } else {
            return String.valueOf(HttpStatus.NOT_FOUND.value());
        }
    }













}
