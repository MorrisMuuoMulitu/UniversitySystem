package mik.pte.university.domain;


import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="country")
public class Country extends AbstractEntity<Long> {

    @Column(name = "country_name")
    private String country_name;
    @Column(name = "country_sign")
    private String country_sign;

    public Country(String country_name, String country_sign) {
        super(null);
        this.country_name = country_name;
        this.country_sign = country_sign;
    }

    public Country(Long id) {
        super(id);
    }

    public Country() {
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_sign() {
        return country_sign;
    }

    public void setCountry_sign(String country_sign) {
        this.country_sign = country_sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        if (!super.equals(o)) return false;
        Country country = (Country) o;
        return getCountry_name().equals(country.getCountry_name()) && getCountry_sign().equals(country.getCountry_sign());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountry_name(), getCountry_sign());
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_name='" + country_name + '\'' +
                ", country_sign='" + country_sign + '\'' +
                '}';
    }
}
