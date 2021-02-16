package catalog.crud.services.impl;

import java.util.List;
import java.util.Optional;

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
		List<ProducerDAO> ProducerList = (List<ProducerDAO>)repository.findAll();
		return ProducerList;

	}

	@Override
	public Optional<ProducerDAO> findById(Long id) {
		Optional<ProducerDAO> ProducerDao = repository.findById(id);
		return ProducerDao;
	}

	@Override
	public ProducerDAO save(ProducerDAO Producer) {
		ProducerDAO ProducerDao = repository.save(Producer);
		return ProducerDao;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
