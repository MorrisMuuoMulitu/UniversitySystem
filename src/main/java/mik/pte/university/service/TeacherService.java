package mik.pte.university.service;

import mik.pte.university.domain.Teacher;
import mik.pte.university.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService extends AbstractService<Teacher,Long>{

    @Autowired
    public TeacherService(AbstractRepository<Teacher, Long> abstractRepository) {
        super(abstractRepository);
    }

    @Override
    public List<Teacher> findAll() {
        return super.findAll();
    }


    @Override
    public void saveObject(Teacher teacher) {
        super.saveObject(teacher);
    }
}
