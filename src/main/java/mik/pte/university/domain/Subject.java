package mik.pte.university.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subject")
public class Subject extends AbstractEntity<Long> {

    @Column(name = "subject_name", nullable = false)
    private String subject_name;

    @Column(name = "student_code", nullable = false)
    private String subject_code;

    @ManyToMany(mappedBy ="subjectSet",fetch = FetchType.EAGER)
    private Set<Student> studentSet = new HashSet<>();



    public Subject() {
    }

    public Subject(Long id) {
        super(id);
    }

    public Subject(String subject_name, String subject_code) {
        this.subject_name = subject_name;
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public void addStudent(Student student) {
        studentSet.add(student);
        student.getSubjectSet().add(this);
    }

    public void removeStudent(Student student) {
        studentSet.remove(student);
        student.getSubjectSet().remove(this);
    }
}
