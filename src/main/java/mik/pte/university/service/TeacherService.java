package mik.pte.university.service;

import mik.pte.university.domain.Student;
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


    public Teacher findBySubjectName(String subject_name){
        for(Teacher t: findAll()){
            if(t.getTeacher_major().equals(subject_name))
                return t;
        }
        return null;
    }

    public void deleteTeacher(Long Id){
        Teacher teacher = findById(Id);

        for(Student s: teacher.getStudentSet()){
            teacher.getStudentSet().remove(s);
        }

        super.deleteById(Id);
    }
}
