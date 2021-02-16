package catalog.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import catalog.dao.BeerDAO;
import models.Beer;

@Component
public class BeerDAOBeerAdapter {
	
	public Beer adapt(BeerDAO beer) {
		Beer beerModel = new Beer();
	   if(!"".equals( beer.getDescription()))  beerModel.setDescription(beer.getDescription());
	   if(!"".equals( beer.getType())) beerModel.setType(beer.getType());
	   if(!"".equals(beer.getGraduation())) beerModel.setGraduation(beer.getGraduation());
	   if(!"".equals(beer.getName())) beerModel.setName(beer.getName());
	   if(!"".equals(beer.getProducer())) beerModel.setProducer(beer.getProducer());
	   beerModel.setId(beer.getId());
	   return beerModel;
	   
	}
	
	public List<Beer> adaptList(List<BeerDAO> beerList){
		List<Beer> modelList = new ArrayList<Beer>();
		 beerList.forEach(beerDao -> {
			 Beer b = new Beer();
			 b = this.adapt(beerDao);
			 modelList.add(b);
		 });
		 return modelList;
	}

}
