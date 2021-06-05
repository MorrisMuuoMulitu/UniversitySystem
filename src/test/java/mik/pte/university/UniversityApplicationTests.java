package mik.pte.university;

import mik.pte.university.controller.StudentController;
import mik.pte.university.domain.Student;
import mik.pte.university.domain.Subject;
import mik.pte.university.repository.StudentRepository;
import mik.pte.university.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class UniversityApplicationTests {
    @Autowired
    CountryService countryservice;
    @Autowired
    UniversityService universityService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    SubjectService subjectService;


    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Create success")
    void initStudentsTeacher(){
        createStudentTeacher("James  Holden", "Aeronautical Engineering", "Kenya", "Aeronautical Engineering Physics");
        createStudentTeacher("Naomi Nagata", "Astro Physics", "Kenya", "Astro Physics");
        createStudentTeacher("Amos Burton", "Military Technology", "Kenya", "Military Science");
    }

    void createStudentTeacher(String name, String course_name, String country, String subject) {

        Student student = new Student(name,course_name,country);

        Subject subject1 = subjectService.findBySubjectName(subject);

        if(subject1 == null){
            String[] codeArr = subject.split(" ");
            char[] sc = new char[codeArr.length];
            for(int i=0; i < codeArr.length; i++){
                sc[i] = codeArr[i].charAt(0);
            }

            Subject s = new Subject(subject,String.valueOf(sc));
            s.addStudent(student);
            student.addSubject(s);
            subjectService.saveObject(s);
            studentService.saveObject(student);
        }
        else {
            student.addSubject(subject1);
            subjectService.saveObject(subject1);
            studentService.saveObject(student);
        }



    }

    @Test
    @DisplayName("Read Success")
    void findById(){
        //Student student = new Student(200L,"James Holden", "Aeronautical Engineering","Ceres Station");
        ;

        //studentService.saveObject(student);

        Assertions.assertNotNull(studentService.findById(2L));
    }

  @Test
    @DisplayName("Üpdate Student Success")
    void updateStudent(){
        Student n = studentService.findById(2L);
        Subject s = new Subject("Deutsch","DE");
        n.getSubjectSet().add(s);
        s.getStudentSet().add(n);
        subjectService.saveObject(s);
        studentService.saveObject(n);

    }

    @Test
    @DisplayName("Delete success")
    void deleteStudent(){
        Long n = studentService.findAll().size()-1L;
        studentService.deleteById(n);
    }

}
