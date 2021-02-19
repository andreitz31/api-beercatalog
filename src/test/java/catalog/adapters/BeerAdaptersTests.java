package catalog.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import catalog.dao.BeerDAO;
import models.Beer;

@SpringBootTest
public class BeerAdaptersTests {
	
	BeerBeerDAOAdapter adapter = new BeerBeerDAOAdapter();
	BeerDAOBeerAdapter adapterReverse = new BeerDAOBeerAdapter();
	
	@Test
	public void testAdaptBeerBeerDAO() {
		
		Beer beer = new Beer();
		beer.setDescription("description");
		beer.setGraduation("1%");
		beer.setId(1L);
		beer.setName("name");
		beer.setProducer("producer");
		beer.setType("type");
		
		
		BeerDAO beerD = new BeerDAO();
		beerD.setDescription("description");
		beerD.setGraduation("1%");
		beerD.setId(1L);
		beerD.setName("name");
		beerD.setProducer("producer");
		beerD.setType("type");
		
		BeerDAO response = adapter.adapt(beer);
		
		assertEquals(response.getName(),beerD.getName());
		assertEquals(response.getDescription(),beerD.getDescription());
		assertEquals(response.getId(),beerD.getId());
		assertEquals(response.getProducer(),beerD.getProducer());
		assertEquals(response.getType(),beerD.getType());
		
		
	}
	
	@Test
	public void testAdaptBeerDAOBeer() {
		
		BeerDAO beer = new BeerDAO();
		beer.setDescription("description");
		beer.setGraduation("1%");
		beer.setId(1L);
		beer.setName("name");
		beer.setProducer("producer");
		beer.setType("type");
		
		
		Beer beerD = new Beer();
		beerD.setDescription("description");
		beerD.setGraduation("1%");
		beerD.setId(1L);
		beerD.setName("name");
		beerD.setProducer("producer");
		beerD.setType("type");
		
		Beer response = adapterReverse.adapt(beer);
		
		assertEquals(response.getName(),beerD.getName());
		assertEquals(response.getDescription(),beerD.getDescription());
		assertEquals(response.getId(),beerD.getId());
		assertEquals(response.getProducer(),beerD.getProducer());
		assertEquals(response.getType(),beerD.getType());
		
		
	}
	
	
	@Test
	public void testAdaptBeerDAOBeerList() {
		
		BeerDAO beer = new BeerDAO();
		beer.setDescription("description");
		beer.setGraduation("1%");
		beer.setId(1L);
		beer.setName("name");
		beer.setProducer("producer");
		beer.setType("type");
		
		
		Beer beerD = new Beer();
		beerD.setDescription("description");
		beerD.setGraduation("1%");
		beerD.setId(1L);
		beerD.setName("name");
		beerD.setProducer("producer");
		beerD.setType("type");
		
		
		BeerDAO beer2 = new BeerDAO();
		beer2.setDescription("description");
		beer2.setGraduation("1%");
		beer2.setId(1L);
		beer2.setName("name");
		beer2.setProducer("producer");
		beer2.setType("type");
		
		
		Beer beerD2 = new Beer();
		beerD2.setDescription("description");
		beerD2.setGraduation("1%");
		beerD2.setId(1L);
		beerD2.setName("name");
		beerD2.setProducer("producer");
		beerD2.setType("type");
		
		
		List<Beer> beerList = new ArrayList<Beer>();
		List<BeerDAO> daoList = new ArrayList<BeerDAO>();
		
		beerList.add(beerD);
		beerList.add(beerD2);
		daoList.add(beer);
		daoList.add(beer2);
		
		
		
		List<Beer> response = adapterReverse.adaptList(daoList);
		
		assertEquals(response.get(0).getName(),beerList.get(0).getName());
		assertEquals(response.get(1).getName(),beerList.get(1).getName());
		
		
		
	}
	
	

}
