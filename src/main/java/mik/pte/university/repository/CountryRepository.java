package mik.pte.university.repository;


import mik.pte.university.domain.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends AbstractRepository<Country, Long>{
    @Override
    List<Country> findAll();
}
