package mik.pte.university.repository;


import mik.pte.university.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StudentRepository extends AbstractRepository<Student, Long>{

    @Override
    @Query("from Student ")
    List<Student> findAll();
}
