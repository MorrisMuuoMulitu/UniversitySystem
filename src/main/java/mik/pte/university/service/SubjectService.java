package mik.pte.university.service;


import mik.pte.university.domain.Student;
import mik.pte.university.domain.Subject;
import mik.pte.university.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends AbstractService<Subject, Long>{

    @Autowired
    public SubjectService(AbstractRepository<Subject, Long> abstractRepository) {
        super(abstractRepository);
    }

    @Override
    public void saveObject(Subject subject) {
        super.saveObject(subject);
    }


    public void deleteSubject(Long Id){
        Subject subject = new Subject();

        for(Student s: subject.getStudentSet()){
            s.getSubjectSet().remove(subject);
            subject.getStudentSet().remove(s);
        }

        super.deleteById(Id);
    }


    public Subject findBySubjectName(String subject){
        for(Subject s : findAll()){
            if(s.getSubject_name().equalsIgnoreCase(subject)){
                return s;
            }
        }
        return null;
    }
}
