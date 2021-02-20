package catalog.servicesimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.adapters.BeerBeerDAOAdapter;
import catalog.adapters.BeerDAOBeerAdapter;
import catalog.crud.services.BeerCRUDService;
import catalog.crud.services.ProducerCRUDService;
import catalog.dao.BeerDAO;
import catalog.dao.ProducerDAO;
import catalog.services.BeerService;
import models.Beer;

@Service
public class BeerServiceImpl implements BeerService {

	@Autowired
	ProducerCRUDService producerCrudService;
	@Autowired
	BeerCRUDService beerCrudService;
	@Autowired
	BeerDAOBeerAdapter adapter;
	@Autowired
	BeerBeerDAOAdapter adapterToDAO;
	@Override
	public Beer getBeer(Long id) {
		
		BeerDAO beerDao;
		try {
			beerDao = beerCrudService.findById(id).get();
		} catch (Exception e) {
			beerDao = new BeerDAO();
		}
		
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
	public List<Beer> getAllBeersSorted() {
		
		List<BeerDAO> beerList = beerCrudService.findAll();
		List<Beer> beers = new ArrayList<Beer>();
        beers = adapter.adaptList(beerList);
        
        Collections.sort(beers);
		return beers;
	}

	@Override
	public Beer addBeer(Beer beer)  {
		
		BeerDAO beerDao = adapterToDAO.adapt(beer);
		Optional<ProducerDAO> producer = producerCrudService.findByName(beer.getProducer());
		beerDao.setProducerId(producer.get().getId());
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

	@Override
	public List<Beer> listByProducer(String producer) {
		List<BeerDAO> beerList = beerCrudService.findByProducer(producer);
		List<Beer> beers = new ArrayList<Beer>();
        beers = adapter.adaptList(beerList);
		return beers;
	}

	@Override
	public List<Beer> listByType(String type) {
		List<BeerDAO> beerList = beerCrudService.findByType(type);
		List<Beer> beers = new ArrayList<Beer>();
        beers = adapter.adaptList(beerList);
		return beers;
	}

}
