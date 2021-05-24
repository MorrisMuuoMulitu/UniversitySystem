package mik.pte.university.service;

import mik.pte.university.domain.AbstractEntity;

import mik.pte.university.repository.AbstractRepository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractService<T extends AbstractEntity<ID>,ID extends Serializable>{

    private final AbstractRepository<T,ID> abstractRepository;

    public AbstractService(AbstractRepository<T, ID> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

   public List<T> findAll(){

        return (List<T>) StreamSupport.stream(abstractRepository.findAll()
        .spliterator(),false).collect(Collectors.toList());
    }

    public void saveObject(T t){
        abstractRepository.saveAndFlush(t);
    }

    public T findById(ID Id){
        return abstractRepository.findById(Id).get();
    }

    public void deleteById(ID id){
        abstractRepository.deleteById(id);
    }

}
