package mik.pte.university.repository;


import mik.pte.university.domain.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends AbstractRepository<Student, Long>{

    @Override
    @Query("from Student ")
    List<Student> findAll();
}
