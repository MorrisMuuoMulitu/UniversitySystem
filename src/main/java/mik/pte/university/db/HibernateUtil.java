package mik.pte.university.db;

import mik.pte.university.domain.*;
import mik.pte.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HibernateUtil implements CommandLineRunner {


    CountryService countryservice;
    UniversityService universityService;
    TeacherService teacherService;
    StudentService studentService;
    SubjectService subjectService;

    StudentInfoService studentInfoService;

    @Autowired
    public HibernateUtil(CountryService countryservice, UniversityService universityService, TeacherService teacherService, StudentService studentService, SubjectService subjectService, StudentInfoService studentInfoService) {
        this.countryservice = countryservice;
        this.universityService = universityService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.studentInfoService = studentInfoService;
    }


    @Override
    public void run(String... args) throws Exception {
        initStudentInfo();
        initCountries();
        initTeacher();
        initUniversity();
        initStudent();
        initStudentsTeacher();
        Student student=studentService.findAll().get(0);
        StudentInfo s=studentInfoService.findAll().get(0);
        student.setStudentInfo(s);
        studentService.saveObject(student);
        initStudentSubjectManyToMany();
        //deleteStudent();
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





    void initUniversity(){
       createUniversity("University of Pécs","PTE","Hungary");
    }

    private void createUniversity(String university_name,String university_code,String university_country) {
       University university=new University(university_name,university_code,university_country);
       universityService.saveObject(university);
    }

    void initStudent(){
        createStudent("Morris Mulitu","Computer science","Kenya",1L);
        createStudent("Vladmir Putin","Political science","Russia",0L);
    }

    void initStudentInfo(){
        createStudentInfo("BVQYMZ", "Scholarship", 7);
        createStudentInfo("JKSUMS","Self sponsored",5);
    }

    private void createStudentInfo(String neptun_code, String financial_status, int active_semesters){
        StudentInfo studentInfo = new StudentInfo(neptun_code, financial_status, active_semesters);
        studentInfoService.saveObject(studentInfo);
    }
    private void createStudent(String student_name,String study_program,String student_country, Long student_info_id) {
        Student student=new Student(student_name,study_program,student_country);
//        if(student_info_id != 0){
//            student.setStudentInfo(studentInfoService.findById(student_info_id));
//        }
        studentService.saveObject(student);
    }

    void initStudentsTeacher(){
        createStudentTeacher("Morris Muuo", "Information Technology", "Kenya", "Experimental Physics");
        createStudentTeacher("Joey Tribiani", "Information Technology", "Kenya", "Pharmacy");
        createStudentTeacher("Morris Muuo", "Information Technology", "Kenya", "Microbiology");
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

    ArrayList<String[]> subjectsArray(){
        ArrayList<String[]> listItems = new ArrayList<String[]>();
       listItems.add(new String[]{"NEE", "Network engineering"});
        listItems.add(new String[]{"SEE","Software Engineering"});
        listItems.add(new String[]{"CAE","Computer Architecture"});



        return listItems;
    }

    void initStudentSubjectManyToMany(){
        createStudentSubject("Chadler Bing", "Communications", "Uganda",subjectsArray());
    }

    private void createStudentSubject(String name, String course_name, String country, ArrayList<String[]> subjectsArray) {
        Student student = new Student(name,course_name,country);

        for(String[] subject : subjectsArray){
            Subject s = new Subject(subject[0],subject[1]);


            s.addStudent(student);
            student.addSubject(s);
            subjectService.saveObject(s);

        }
        studentService.saveObject(student);
    }

    private void deleteStudent(){
        studentService.deleteStudent(6L);
    }


}
