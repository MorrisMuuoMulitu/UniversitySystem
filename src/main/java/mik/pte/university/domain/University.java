package mik.pte.university.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="university")
public class University extends AbstractEntity<Long> {


    @Column(name = "university_name", nullable = false)
    private String university_name;


    @Column(name = "university_code", nullable = false)
    private String university_code;

    @Column(name = "university_country", nullable = false)
    private String university_Country;


    public University(String university_name, String university_code, String university_Country) {
        this.university_name = university_name;
        this.university_code = university_code;
        this.university_Country = university_Country;
    }

    public University() {
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getUniversity_code() {
        return university_code;
    }

    public void setUniversity_code(String university_code) {
        this.university_code = university_code;
    }

    public String getUniversity_Country() {
        return university_Country;
    }

    public void setUniversity_Country(String university_Country) {
        this.university_Country = university_Country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        if (!super.equals(o)) return false;
        University that = (University) o;
        return getUniversity_name().equals(that.getUniversity_name()) && getUniversity_code().equals(that.getUniversity_code()) && getUniversity_Country().equals(that.getUniversity_Country());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUniversity_name(), getUniversity_code(), getUniversity_Country());
    }
}
