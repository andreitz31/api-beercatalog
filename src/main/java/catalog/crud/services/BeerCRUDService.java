package catalog.crud.services;

import java.util.List;

import catalog.dao.BeerDAO;

public interface BeerCRUDService {
	
	List<BeerDAO> findAll();

}
