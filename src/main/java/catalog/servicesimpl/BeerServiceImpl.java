package catalog.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.crud.services.BeerCRUDService;
import catalog.dao.BeerDAO;
import catalog.services.BeerService;
import models.Beer;

@Service
public class BeerServiceImpl implements BeerService {

	@Autowired
	BeerCRUDService beerCrudService;
	@Override
	public Beer getBeer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beer> getAllBeers() {
		
		List<BeerDAO> beerDAO = beerCrudService.findAll();
		return null;
	}

	@Override
	public Beer addBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beer updateBeer(Beer beer, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beer deleteBeer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
