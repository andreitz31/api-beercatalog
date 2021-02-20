package catalog.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
		ResponseEntity<Beer> response;
			Beer beer = beerService.getBeer(id);
			response = ResponseEntity.accepted().body(beer);

		return response;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "List beers", notes= "This method gets the information of all beers")
	public ResponseEntity<List<Beer>> listBeer(){
		ResponseEntity<List<Beer>> response;
		try {
			List<Beer> beerList = beerService.getAllBeers();
			response = ResponseEntity.accepted().body(beerList);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return response;
		
	}
	
	@GetMapping("/sorted")
	@ApiOperation(value = "List beers sorted alphabetically", notes= "This method gets the information of all beers sorted alphabetically")
	public ResponseEntity<List<Beer>> listBeerSorted(){
		ResponseEntity<List<Beer>> response;
		try {
			List<Beer> beerList = beerService.getAllBeersSorted();
			response = ResponseEntity.accepted().body(beerList);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return response;
		
	}
	
	@GetMapping("/byType/{type}")
	@ApiOperation(value = "List beers by type", notes= "This method gets the information of all beers of one type")
	public ResponseEntity<List<Beer>> listBeerByType(@PathVariable String type){
		ResponseEntity<List<Beer>> response;
		try {
			List<Beer> beerList = beerService.listByType(type);
			response = ResponseEntity.accepted().body(beerList);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return response;
		
	}
	
	@GetMapping("/byProducer/{producer}")
	@ApiOperation(value = "List beers by producer", notes= "This method gets the information of all beers of one producer")
	public ResponseEntity<List<Beer>> listBeerByProducer(@PathVariable String producer){
		ResponseEntity<List<Beer>> response;
		try {
			List<Beer> beerList = beerService.listByProducer(producer);
			response = ResponseEntity.accepted().body(beerList);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_PRODUCER"})
	@PostMapping("/addBeer")
	@ApiOperation(value = "Add beer", notes= "This method adds the information of a beer")
	public ResponseEntity<Beer> addBeer(@RequestBody Beer beer,Principal principal){
		ResponseEntity<Beer> response;
		
		// check is is entitled to add the product
		if(!beer.getProducer().equals(principal.getName())){
			
			response = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			 return response;
		}
		try {
			Beer beerResponse = beerService.addBeer(beer);
			response = ResponseEntity.accepted().body(beerResponse);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_PRODUCER"})
	@PutMapping("/updateBeer/{id}")
	@ApiOperation(value = "Update beer", notes= "This method updates the information of a beer")
	public ResponseEntity<Beer> updateBeer(@RequestBody Beer beer, @PathVariable Long id, Principal principal){
		ResponseEntity<Beer> response;
		
		// check is is entitled to add the product
		if(!beer.getProducer().equals(principal.getName())){
			
			response = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			 return response;
		}
		try {
			Beer beerResponse = beerService.updateBeer(beer,id);
			response = ResponseEntity.accepted().body(beerResponse);
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/deleteBeer/{id}")
	@ApiOperation(value = "Delete beer", notes= "This method deletes the information of a beer")
	public ResponseEntity<Beer> deleteBeer(@PathVariable Long id){
		ResponseEntity<Beer> response;
		try {
			beerService.deleteBeer(id);
			response = ResponseEntity.accepted().build();
		} catch (Exception e) {
			response =  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
		
	}

}
