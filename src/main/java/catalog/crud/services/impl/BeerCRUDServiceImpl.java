package catalog.crud.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.crud.services.BeerCRUDService;
import catalog.dao.BeerDAO;
import catalog.repository.BeerRepository;

@Service
public class BeerCRUDServiceImpl implements BeerCRUDService {
	
	@Autowired
	private BeerRepository repository;

	@Override
	public List<BeerDAO> findAll() {
		
		List<BeerDAO> beerList = (List<BeerDAO>)repository.findAll();
		return beerList;
	}

}
