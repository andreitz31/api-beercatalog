package catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
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
		Producer Producer = producerService.getProducer(id);
		ResponseEntity<Producer> response = ResponseEntity.accepted().body(Producer);
		return response;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "List beer manufacturer", notes= "This method list the information of all beer manufacturers")
	public ResponseEntity<List<Producer>> listProducer(){
		List<Producer> ProducerList = producerService.getAllProducers();
		ResponseEntity<List<Producer>> response =  ResponseEntity.accepted().body(ProducerList);
		return response;
		
	}
	
	@PostMapping("/addProducer")
	@ApiOperation(value = "Add beer manufacturer", notes= "This method adds the information of a beer manufacturer")
	public ResponseEntity<Producer> addProducer(@RequestBody Producer Producer){
		Producer ProducerResponse = producerService.addProducer(Producer);
		ResponseEntity<Producer> response = ResponseEntity.accepted().body(ProducerResponse);
		return response;
		
	}
	
	@PutMapping("/updateProducer/{id}")
	@ApiOperation(value = "Update beer manufacturer", notes= "This method updates the information of a beer manufacturer")
	public ResponseEntity<Producer> updateProducer(@RequestBody Producer Producer, @PathVariable Long id){
		Producer ProducerResponse = producerService.updateProducer(Producer,id);
		ResponseEntity<Producer> response = ResponseEntity.accepted().body(ProducerResponse);
		return response;
		
	}
	
	@DeleteMapping("/deleteProducer/{id}")
	@ApiOperation(value = "Delete beer manufacturer", notes= "This method deletes the information of a beer manufacturer")
	public ResponseEntity<Producer> deleteProducer(@PathVariable Long id){
		producerService.deleteProducer(id);
		ResponseEntity<Producer> response = ResponseEntity.accepted().build();
		return response;
		
	}

}

