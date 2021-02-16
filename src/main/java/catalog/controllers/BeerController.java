package catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalog.services.BeerService;
import io.swagger.annotations.ApiOperation;
import models.Beer;

@RestController
@RequestMapping("/api/beers")
public class BeerController {
	
	@Autowired
	BeerService beerService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get beer", notes= "This method gets the information of a beer")
	public ResponseEntity<Beer> getBeer(@PathVariable Long id) {
		Beer beer = beerService.getBeer(id);
		ResponseEntity<Beer> response = ResponseEntity.accepted().body(beer);
		return response;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "List beers", notes= "This method gets the information of all beers")
	public ResponseEntity<List<Beer>> listBeer(){
		List<Beer> beerList = beerService.getAllBeers();
		ResponseEntity<List<Beer>> response =  ResponseEntity.accepted().body(beerList);
		return response;
		
	}
	
	@PostMapping("/addBeer")
	@ApiOperation(value = "Add beer", notes= "This method adds the information of a beer")
	public ResponseEntity<Beer> addBeer(@RequestBody Beer beer){
		Beer beerResponse = beerService.addBeer(beer);
		ResponseEntity<Beer> response = ResponseEntity.accepted().body(beerResponse);
		return response;
		
	}
	
	@PutMapping("/updateBeer/{id}")
	@ApiOperation(value = "Update beer", notes= "This method updates the information of a beer")
	public ResponseEntity<Beer> updateBeer(@RequestBody Beer beer, @PathVariable Long id){
		Beer beerResponse = beerService.updateBeer(beer,id);
		ResponseEntity<Beer> response = ResponseEntity.accepted().body(beerResponse);
		return response;
		
	}
	
	@DeleteMapping("/deleteBeer/{id}")
	@ApiOperation(value = "Delete beer", notes= "This method deletes the information of a beer")
	public ResponseEntity<Beer> deleteBeer(@PathVariable Long id){
		Beer beerResponse = beerService.deleteBeer(id);
		ResponseEntity<Beer> response = ResponseEntity.accepted().body(beerResponse);
		return response;
		
	}

}
