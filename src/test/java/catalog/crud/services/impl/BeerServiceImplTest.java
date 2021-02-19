package catalog.crud.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import catalog.dao.BeerDAO;

@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class BeerServiceImplTest {
	
	BeerCRUDServiceImpl beerService = new BeerCRUDServiceImpl();
	
	@Test
	@Rollback(false)
	public void testCreateProduct() {
		
	    BeerDAO savedBeer = new BeerDAO();
	    
	    savedBeer.setId(100L);
	    savedBeer.setName("TESTBEER");
	    savedBeer.setDescription("desc");
	    savedBeer.setGraduation("1%");
	    savedBeer.setProducer("Grolsch");
	    savedBeer.setProducerId(1L);
	    savedBeer.setType("TYPE");
	    
	    beerService.save(savedBeer);
	    
	    BeerDAO beerDAO = beerService.findById(100L).get();
	    
	    assertEquals(beerDAO.getId(),100L);

	    
	   
	}

}
