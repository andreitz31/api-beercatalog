package catalog.crud.services;

import java.util.List;
import java.util.Optional;

import catalog.dao.BeerDAO;

public interface BeerCRUDService {
	
	List<BeerDAO> findAll();
	Optional<BeerDAO> findById(Long id);
	BeerDAO save(BeerDAO beer);
	void delete(Long id);

}
