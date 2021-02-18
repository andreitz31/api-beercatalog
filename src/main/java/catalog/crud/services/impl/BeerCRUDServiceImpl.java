package catalog.crud.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
	public List<BeerDAO> findAll(){
		List<BeerDAO> beerList = (List<BeerDAO>)repository.findAll();
		return beerList;

	}

	@Override
	public Optional<BeerDAO> findById(Long id) {
		Optional<BeerDAO> beerDao = repository.findById(id);

		return beerDao;
	}

	@Override
	public BeerDAO save(BeerDAO beer) {
		BeerDAO beerDao = repository.save(beer);
		return beerDao;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
