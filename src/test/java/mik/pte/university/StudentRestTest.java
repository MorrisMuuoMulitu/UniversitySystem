package mik.pte.university;

import mik.pte.university.controller.StudentController;
import mik.pte.university.domain.Student;
import mik.pte.university.repository.AbstractRepository;
import mik.pte.university.repository.StudentRepository;
import mik.pte.university.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentRestTest{



    @Autowired
    private MockMvc mockMvc;
    @MockBean
    Student student;
    @MockBean
    StudentRepository studentRepository;


    @MockBean
    StudentController studentController;
    @MockBean
    StudentService studentService;
    @MockBean
    TeacherService teacherService;
    @MockBean
    StudentInfoService studentInfoService;



    @Test
    public void getAllStudentsTest() throws Exception {

        this.mockMvc.perform(get("http://localhost:8082/student"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"))
                .andDo(print());

    }
    @Test
    public void addGetRequestTest() throws Exception {

        this.mockMvc.perform(get("/student/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentCreate"))

                .andDo(print());
    }


    @Test
    public void addNewStudent() throws Exception {
        String student_name = "Jack";
        String study_program = "CS";
        String student_country = "Azerbaijan";

        mockMvc.perform(post("/student/add")
                .param("student_name", student_name)
                .param("study_program", study_program)
                .param("student_country",student_country)
        ) .andExpect(status().isOk())
                .andExpect(view().name("students"))

                .andDo(print());
    }

//    @Test
//    public void testMorePage() throws Exception {
//
//        studentService.saveObject(new Student("M","cs","S"));
//        List<Student> student =studentService.findAll();
//
//        this.mockMvc.perform(get("/student/morepage/1"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("studentMore"))
//                .andDo(print());
//    }


}
