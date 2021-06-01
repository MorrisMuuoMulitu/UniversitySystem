package mik.pte.university.repository;

import mik.pte.university.domain.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends AbstractRepository<Teacher, Long>{

    @Override
    @Query("from Teacher ")
    List<Teacher> findAll();
}
