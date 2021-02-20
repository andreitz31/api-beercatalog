package catalog.crud.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.crud.services.ProducerCRUDService;
import catalog.dao.ProducerDAO;
import catalog.repository.ProducerRepository;


@Service
public class ProducerCRUDServiceImpl implements ProducerCRUDService {
	
	@Autowired
	private ProducerRepository repository;
	
	@Override
	public List<ProducerDAO> findAll() {
		List<ProducerDAO> producerList = (List<ProducerDAO>)repository.findAll();
		return producerList;

	}

	@Override
	public Optional<ProducerDAO> findById(Long id) {
		Optional<ProducerDAO> producerDao = repository.findById(id);
		if(!producerDao.isPresent()) {
			throw  new EntityNotFoundException();
		}
		return producerDao;
	}

	@Override
	public ProducerDAO save(ProducerDAO Producer) {
		ProducerDAO producerDao = repository.save(Producer);
		return producerDao;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<ProducerDAO> findByName(String name){
		Optional<ProducerDAO> producerDao = repository.findByName(name);
		return producerDao;
	}

}
