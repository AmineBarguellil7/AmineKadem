package tn.esprit.aminekadem.Generic;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;



public class IGenericServiceImpl<T,ID> implements IGenericService<T,ID>{
    @Autowired
    JpaRepository<T,ID> jpaRepository;


    @Override
    public List<T> retrieveAll() {
        return jpaRepository.findAll();
    }

    @Override
    public T add(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public T retrieveById(ID id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(ID id) {
        if (jpaRepository.findById(id).isPresent())
            jpaRepository.deleteById(id);
    }
}
