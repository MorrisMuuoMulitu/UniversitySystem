package mik.pte.university.service;

import mik.pte.university.domain.Student;
import mik.pte.university.domain.Subject;
import mik.pte.university.domain.Teacher;
import mik.pte.university.repository.AbstractRepository;
import mik.pte.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends AbstractService<Student,Long>{



    @Autowired
    public StudentService(AbstractRepository<Student, Long> abstractRepository) {
        super(abstractRepository);
    }

    @Override
    public List<Student> findAll() {
        return super.findAll();
    }


    @Override
    public void saveObject(Student student) {
        super.saveObject(student);
    }

    public void deleteStudent(Long Id){


//        for(Subject s : student.getSubjectSet()){
//            s.getStudentSet().remove(student);
//        }
//        saveObject(student);
        super.deleteById(Id);
    }



}
