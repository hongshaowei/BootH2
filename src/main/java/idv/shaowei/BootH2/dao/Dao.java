package idv.shaowei.BootH2.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Dao<T> {
	Optional<T> fetch(int id) throws Exception;
    
    List<T> fetchAll() throws Exception;
     
    void save(T t) throws Exception;
     
    void update(int id, Map<String, String> params) throws Exception;
     
    void delete(int id) throws Exception;
}
