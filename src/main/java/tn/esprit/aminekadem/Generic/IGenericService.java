package tn.esprit.aminekadem.Generic;

import java.util.List;

public interface IGenericService<T,ID> {
    public List<T> retrieveAll();

    public T add (T entity);

    public T update (T entity);

    public T retrieveById (ID id);

    public void remove(ID id);
}
