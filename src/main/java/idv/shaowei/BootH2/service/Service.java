package idv.shaowei.BootH2.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Service<T> {
	Optional<T> fetch(int id);
    
    List<T> fetchAll();
     
    void save(T t);
     
    void update(int id, Map<String, String> params);
     
    void delete(int id);
}
