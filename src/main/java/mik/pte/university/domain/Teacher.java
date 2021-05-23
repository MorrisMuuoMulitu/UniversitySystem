package mik.pte.university.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="teacher")
public class Teacher extends AbstractEntity<Long> {

    @Column(name = "teacher_name", nullable = false,unique = true)
    @Size(min=2,max=50,message="Name length must be between 2 and 50")
    private String teacher_name;

    @Column(name = "teacher_age",nullable = false)
    private int teacher_age;

    @Column(name = "teacher_major",nullable = false,unique = true)
    private String teacher_major;

    @Column(name="teacher_country",nullable = false)
    private String country;

    public Teacher(Long id, String teacher_name, int teacher_age, String teacher_major,String country) {
        super(id);
        this.teacher_name = teacher_name;
        this.teacher_age = teacher_age;
        this.teacher_major = teacher_major;
        this.country = country;
    }

    public Teacher(String teacher_name, int teacher_age, String teacher_major,String country) {
        this.teacher_name = teacher_name;
        this.teacher_age = teacher_age;
        this.teacher_major = teacher_major;
        this.country=country;
    }

    public Teacher() {

    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getTeacher_age() {
        return teacher_age;
    }

    public void setTeacher_age(int teacher_age) {
        this.teacher_age = teacher_age;
    }

    public String getTeacher_major() {
        return teacher_major;
    }

    public void setTeacher_major(String teacher_major) {
        this.teacher_major = teacher_major;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return getTeacher_age() == teacher.getTeacher_age() && getTeacher_name().equals(teacher.getTeacher_name()) && getTeacher_major().equals(teacher.getTeacher_major()) && getCountry().equals(teacher.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTeacher_name(), getTeacher_age(), getTeacher_major(), getCountry());
    }
}
