package daos;

import java.util.List;

public interface DAOInterface<T> {
//    A DAO abstract class or interface for the following methods
//
//    public T findById(int id);
//    public List findAll();
//    public T update(T dto);
//    public T create(T dto);
//    public void delete(int id);

    Vegetables findById(Integer id);
    List<Vegetables> findAll();
    Boolean update(Vegetables dto);
    Boolean create(Vegetables dto);
    Boolean delete(Integer id);




}
