package mik.pte.university.db;

import mik.pte.university.domain.Country;
import mik.pte.university.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class HibernateUtil implements CommandLineRunner {

    @Autowired
    private CountryService countryservice;

    @Override
    public void run(String... args) throws Exception {
        initCountries();
    }

    void initCountries(){
        createCountry("Kenya", "KE");
    }

    private void createCountry(String country_name, String country_sign) {
        Country country = new Country(country_name, country_sign);
        countryservice.addCountry(country);
    }
}
