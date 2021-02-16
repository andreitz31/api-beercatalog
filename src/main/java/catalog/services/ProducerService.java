package catalog.services;

import java.util.List;

import models.Producer;

public interface ProducerService {
	
	public Producer addProducer(Producer producer);
	public Producer updateProducer(Producer producer, Long id);
	public Producer getProducer(Long id);
	public List<Producer> getAllProducers();
	public Producer deleteProducer(Long id);
		
	

}
