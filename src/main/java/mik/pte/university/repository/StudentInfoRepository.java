package mik.pte.university.repository;

import mik.pte.university.domain.StudentInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoRepository extends AbstractRepository<StudentInfo,Long> {
}
