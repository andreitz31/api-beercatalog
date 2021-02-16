package catalog.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.adapters.BeerBeerDAOAdapter;
import catalog.adapters.BeerDAOBeerAdapter;
import catalog.crud.services.BeerCRUDService;
import catalog.dao.BeerDAO;
import catalog.services.BeerService;
import models.Beer;

@Service
public class BeerServiceImpl implements BeerService {

	@Autowired
	BeerCRUDService beerCrudService;
	@Autowired
	BeerDAOBeerAdapter adapter;
	@Autowired
	BeerBeerDAOAdapter adapterToDAO;
	@Override
	public Beer getBeer(Long id) {
		BeerDAO beerDao = beerCrudService.findById(id).get();
		return this.adapter.adapt(beerDao);
	}

	@Override
	public List<Beer> getAllBeers() {
		
		List<BeerDAO> beerList = beerCrudService.findAll();
		List<Beer> beers = new ArrayList<Beer>();
        beers = adapter.adaptList(beerList);
		return beers;
	}

	@Override
	public Beer addBeer(Beer beer) {
		
		BeerDAO beerDao = adapterToDAO.adapt(beer);
		BeerDAO beerDAOResponse = beerCrudService.save(beerDao);
		return adapter.adapt(beerDAOResponse);
	}

	@Override
	public Beer updateBeer(Beer beer, Long id) {
		BeerDAO toBeUpdated = beerCrudService.findById(id).get();
		beer.setId(toBeUpdated.getId());
		BeerDAO updatedBeer = beerCrudService.save(this.adapterToDAO.adapt(beer));
		
		return this.adapter.adapt(updatedBeer);
	}

	@Override
	public void deleteBeer(Long id) {
		
		beerCrudService.delete(id);
	}

}
