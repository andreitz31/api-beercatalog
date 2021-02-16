package catalog.crud.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.crud.services.ProducerCRUDService;
import catalog.repository.BeerRepository;

@Service
public class ProducerCRUDServiceImpl implements ProducerCRUDService {
	
	@Autowired
	private BeerRepository repository;

}
