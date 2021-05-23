package mik.pte.university.db;

import mik.pte.university.domain.Country;
import mik.pte.university.domain.Student;
import mik.pte.university.domain.Teacher;
import mik.pte.university.domain.University;
import mik.pte.university.service.CountryService;
import mik.pte.university.service.StudentService;
import mik.pte.university.service.TeacherService;
import mik.pte.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil implements CommandLineRunner {

    @Autowired
    private CountryService countryservice;

    @Override
    public void run(String... args) throws Exception {
        initCountries();
        initTeacher();
        initUniversity();
        initStudent();
    }


    void initCountries(){
        createCountry("Kenya", "KE");
        createCountry("Hungary", "HU");
        createCountry("Russia", "RU");
        createCountry("United States", "USA");
        createCountry("India", "IND");
        createCountry("Canada", "CND");
        createCountry("Germany", "GER");
    }

    private void createCountry(String country_name, String country_sign) {
        Country country = new Country(country_name, country_sign);
        countryservice.saveObject(country);
    }

    @Autowired
    private TeacherService teacherService;

   void initTeacher(){
       createTeacher("Leonard Hofstadter",45,"Experimental Physics","United States");
       createTeacher("Sheldon Lee Cooper",41,"Theoretical Physics","Russia");
       createTeacher("Rajesh Koothrappali ",41,"Astrophysics","India");
       createTeacher("Penny Hofstadter",34,"Pharmacy","Canada");
       createTeacher("Bernadette Rostenkowski",37,"Microbiology","Germany");

   }

    private void createTeacher(String teacher_name, int teacher_age, String teacher_major, String country) {
        Teacher teacher=new Teacher(teacher_name,teacher_age,teacher_major,country);
        teacherService.saveObject(teacher);
    }
    @Autowired
    private UniversityService universityService;

    void initUniversity(){
       createUniversity("University of Pécs","PTE","Hungary");
    }

    private void createUniversity(String university_name,String university_code,String university_country) {
       University university=new University(university_name,university_code,university_country);
       universityService.saveObject(university);
    }

    @Autowired
    private StudentService studentService;

    void initStudent(){
        createStudent("Morris Mulitu","Computer science","Kenya");
        createStudent("Vladmir Putin","Political science","Russia");
    }

    private void createStudent(String student_name,String study_program,String student_country) {
        Student student=new Student(student_name,study_program,student_country);
        studentService.saveObject(student);
    }
}
