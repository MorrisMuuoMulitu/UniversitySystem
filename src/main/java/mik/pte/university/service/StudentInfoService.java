package mik.pte.university.service;

import mik.pte.university.domain.StudentInfo;
import mik.pte.university.repository.AbstractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService extends AbstractService<StudentInfo,Long>{


    public StudentInfoService(AbstractRepository<StudentInfo, Long> abstractRepository) {
        super(abstractRepository);
    }

    @Override
    public List<StudentInfo> findAll() {
        return super.findAll();
    }
}
