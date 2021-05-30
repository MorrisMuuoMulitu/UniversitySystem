package mik.pte.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class StudentInfo extends AbstractEntity<Long>  {

    @Column(name = "neptun_code", nullable = false)
    private String neptun_code;

    @Column(name = "financial_status", nullable = false)
    private String financial_status;

    @Column(name = "active_semesters", nullable = false)
    private int active_semesters;

    @OneToOne(mappedBy = "studentInfo")
    private Student student;


    public StudentInfo() {
    }

    public StudentInfo(String neptun_code, String financial_status, int active_semesters) {
        super(null);
        this.neptun_code = neptun_code;
        this.financial_status = financial_status;
        this.active_semesters = active_semesters;
    }

    public StudentInfo(Long id) {
        super(id);
    }

    public String getNeptun_code() {
        return neptun_code;
    }

    public void setNeptun_code(String neptun_code) {
        this.neptun_code = neptun_code;
    }

    public String getFinancial_status() {
        return financial_status;
    }

    public void setFinancial_status(String financial_status) {
        this.financial_status = financial_status;
    }

    public int getActive_semesters() {
        return active_semesters;
    }

    public void setActive_semesters(int active_semesters) {
        this.active_semesters = active_semesters;
    }
}
