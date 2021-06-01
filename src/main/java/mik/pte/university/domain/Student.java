package mik.pte.university.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name="student")
public class Student extends AbstractEntity<Long> {



    @Column(name = "student_name", nullable = false)
    private String student_name;

    @Column(name = "study_name", nullable = false)
    private String study_program;

    @Column(name = "student_country", nullable = false)
    private String student_country;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "FLD_TEACHER",referencedColumnName = "id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Subject> subjectSet = new HashSet<>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="student_info", referencedColumnName = "id")
    private StudentInfo studentInfo;

    public Student(Long id, String student_name, String study_program, String student_country) {
        super(id);
        this.student_name = student_name;
        this.study_program = study_program;
        this.student_country = student_country;
    }

    public Student(String student_name, String study_program, String student_country) {
        this.student_name = student_name;
        this.study_program = study_program;
        this.student_country = student_country;
    }



    public Student() {

    }

    public Student(String student_name, String study_program, String student_country, Teacher teacher) {
        this.student_name = student_name;
        this.study_program = study_program;
        this.student_country = student_country;
        this.teacher = teacher;
    }

    public Student(String student_name, String study_program, String student_country, Teacher teacher, Set<Subject> subjectSet) {
        this.student_name = student_name;
        this.study_program = study_program;
        this.student_country = student_country;
        this.teacher = teacher;
        this.subjectSet = subjectSet;
    }

    public Student(String student_name, String study_program, String student_country, StudentInfo studentInfo) {
        this.student_name = student_name;
        this.study_program = study_program;
        this.student_country = student_country;
        this.studentInfo = studentInfo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudy_program() {
        return study_program;
    }

    public void setStudy_program(String study_program) {
        this.study_program = study_program;
    }

    public String getStudent_country() {
        return student_country;
    }

    public void setStudent_country(String student_country) {
        this.student_country = student_country;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public void addSubject(Subject subject) {
        subjectSet.add(subject);
        subject.getStudentSet().add(this);
    }

    public void removeSubject(Subject subject) {
        subjectSet.remove(subject);
        subject.getStudentSet().remove(this);
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }
}


