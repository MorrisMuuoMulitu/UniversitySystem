package mik.pte.university.repository;


import mik.pte.university.domain.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends AbstractRepository<Subject,Long>{

    @Override
    @Query("from Subject")
    List<Subject> findAll();
}
