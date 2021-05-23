package mik.pte.university.service;

import mik.pte.university.domain.University;
import mik.pte.university.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService extends AbstractService<University,Long>{

    @Autowired
    public UniversityService(AbstractRepository<University, Long> abstractRepository) {
        super(abstractRepository);
    }

    @Override
    public List<University> findAll() {
        return super.findAll();
    }


    @Override
    public void saveObject(University university) {
        super.saveObject(university);
    }
}
