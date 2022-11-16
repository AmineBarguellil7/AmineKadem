package tn.esprit.aminekadem.Generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class GenericController<T,ID> {

    @Autowired
    IGenericService<T,ID> iGenericService;

    @PostMapping("/add")
    public T create(@RequestBody T entity) {
        return iGenericService.add(entity);
    }

    @GetMapping("")
    public List<T> read() {
        return iGenericService.retrieveAll();
    }

    @PutMapping("/update")
    public T update(@RequestBody T entity) {
        return iGenericService.update(entity);
    }

    @GetMapping("/read_T/{idT}")
    public T read_T(@PathVariable ID idT) {
        return iGenericService.retrieveById(idT);
    }


    @DeleteMapping("/delete/{idT}")
    public void delete(@PathVariable ID idT) {
        iGenericService.remove(idT);
    }

}
