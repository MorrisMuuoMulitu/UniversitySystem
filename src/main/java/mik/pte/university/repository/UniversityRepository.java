package mik.pte.university.repository;

import mik.pte.university.domain.University;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversityRepository extends AbstractRepository<University, Long>{

    @Override
    @Query("from University ")
    List<University> findAll();
}
