package mik.pte.university.repository;

import mik.pte.university.domain.University;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends AbstractRepository<University, Long>{

    @Override
    @Query("from University ")
    List<University> findAll();
}
