package mik.pte.university.service;

import mik.pte.university.domain.Country;
import mik.pte.university.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends AbstractService<Country, Long>{

    @Autowired
    public CountryService(AbstractRepository<Country, Long> abstractRepository) {
        super(abstractRepository);
    }


    @Override
   public List<Country> findAll() {
        return super.findAll();
   }


    @Override
    public void saveObject(Country country) {
        super.saveObject(country);
    }


    @Override
    public Country findById(Long Id) {
        return super.findById(Id);
    }

    @Override
    public void deleteById(Long Id) {
        super.deleteById(Id);
    }

    public void postEdit(Long Id, Country country){
            Country c = findById(Id);
            c.setCountry_name(country.getCountry_name());
            c.setCountry_sign(country.getCountry_sign());
            saveObject(c);
    }
}
