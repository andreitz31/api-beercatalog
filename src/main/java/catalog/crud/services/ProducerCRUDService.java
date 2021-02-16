package catalog.crud.services;

import java.util.List;
import java.util.Optional;

import catalog.dao.ProducerDAO;


public interface ProducerCRUDService {
	
	List<ProducerDAO> findAll();
	Optional<ProducerDAO> findById(Long id);
	ProducerDAO save(ProducerDAO beer);
	void delete(Long id);

}
