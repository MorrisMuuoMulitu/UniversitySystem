package mik.pte.university.domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Data
@ToString

@Entity
@Table(name="student")
public class Student extends AbstractEntity<Long>{

    @Column(name = "student_name",nullable = false)
    private String student_name;

    @Column(name = "study_name",nullable = false)
    private String study_program;

    public Student(Long id, String student_name, String study_program) {
        super(id);
        this.student_name = student_name;
        this.study_program = study_program;
    }

    public Student(Long id) {
        super(id);
    }

    public Student() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getStudent_name(), student.getStudent_name()) && Objects.equals(getStudy_program(), student.getStudy_program());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudent_name(), getStudy_program());
    }
}
