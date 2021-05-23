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
public class Student extends AbstractEntity<Long> {

    @Column(name = "student_name", nullable = false)
    private String student_name;

    @Column(name = "study_name", nullable = false)
    private String study_program;

    @Column(name = "student_country", nullable = false)
    private String student_country;

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
}


