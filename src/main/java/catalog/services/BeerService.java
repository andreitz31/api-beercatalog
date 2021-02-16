package catalog.services;

import java.util.List;

import models.Beer;

public interface BeerService {
	
	public Beer getBeer(Long id);
	public List<Beer> getAllBeers();
	public Beer addBeer(Beer beer);
	public Beer updateBeer(Beer beer,Long id);
	public void deleteBeer(Long id);

}
