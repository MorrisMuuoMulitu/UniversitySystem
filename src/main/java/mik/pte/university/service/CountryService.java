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


}
