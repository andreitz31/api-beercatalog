package catalog.adapters;

import org.springframework.stereotype.Component;

import catalog.dao.BeerDAO;
import models.Beer;

@Component
public class BeerBeerDAOAdapter {
	
	public BeerDAO adapt(Beer beer) {

		BeerDAO beerModel = new BeerDAO();
	   if(!"".equals( beer.getDescription()))  beerModel.setDescription(beer.getDescription());
	   if(!"".equals( beer.getType())) beerModel.setType(beer.getType());
	   if(!"".equals(beer.getGraduation())) beerModel.setGraduation(beer.getGraduation());
	   if(!"".equals(beer.getName())) beerModel.setName(beer.getName());
	   if(!"".equals(beer.getProducer())) beerModel.setProducer(beer.getProducer());
	   beerModel.setId(beer.getId());

	   return beerModel;
	   
	}

}
