package catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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
import catalog.services.ProducerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import models.Producer;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {
	
	@Autowired
	ProducerService producerService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get a beer manufacturer", notes= "This method gets the information of a beer manufacturer")
	public ResponseEntity<Producer> getProducer(@PathVariable Long id) {
		ResponseEntity<Producer> response;
		try {
			Producer Producer = producerService.getProducer(id);
			response = ResponseEntity.accepted().body(Producer);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return response;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "List beer manufacturer", notes= "This method list the information of all beer manufacturers")
	public ResponseEntity<List<Producer>> listProducer(){
		ResponseEntity<List<Producer>> response;
		try {
			List<Producer> ProducerList = producerService.getAllProducers();
			response = ResponseEntity.accepted().body(ProducerList);
		} catch (Exception e) {
			response = ResponseEntity.badRequest().build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/addProducer")
	@ApiOperation(value = "Add beer manufacturer", notes= "This method adds the information of a beer manufacturer")
	public ResponseEntity<Producer> addProducer(@RequestBody Producer Producer){
		ResponseEntity<Producer> response;
		try {
			Producer ProducerResponse = producerService.addProducer(Producer);
			response = ResponseEntity.accepted().body(ProducerResponse);
		} catch (Exception e) {
			response = ResponseEntity.badRequest().build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/updateProducer/{id}")
	@ApiOperation(value = "Update beer manufacturer", notes= "This method updates the information of a beer manufacturer")
	public ResponseEntity<Producer> updateProducer(@RequestBody Producer Producer, @PathVariable Long id){
		ResponseEntity<Producer> response;
		try {
			Producer ProducerResponse = producerService.updateProducer(Producer,id);
			response = ResponseEntity.accepted().body(ProducerResponse);
		} catch (Exception e) {
			response = ResponseEntity.badRequest().build();
		}
		return response;
		
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/deleteProducer/{id}")
	@ApiOperation(value = "Delete beer manufacturer", notes= "This method deletes the information of a beer manufacturer")
	public ResponseEntity<Producer> deleteProducer(@PathVariable Long id){
		ResponseEntity<Producer> response;
		try {
			producerService.deleteProducer(id);
			response = ResponseEntity.accepted().build();
		} catch (Exception e) {
			response = ResponseEntity.badRequest().build();
		}
		return response;
		
	}

}

