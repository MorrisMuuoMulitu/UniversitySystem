package mik.pte.university.repository;

import mik.pte.university.domain.Teacher;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends AbstractRepository<Teacher, Long>{

    @Override
    @Query("from Teacher ")
    List<Teacher> findAll();
}
