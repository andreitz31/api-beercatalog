package catalog.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.adapters.ProducerProducerDAOAdapter;
import catalog.adapters.ProducerDAOProducerAdapter;
import catalog.crud.services.ProducerCRUDService;
import catalog.dao.ProducerDAO;
import catalog.services.ProducerService;
import models.Producer;
import models.Producer;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	ProducerCRUDService ProducerCrudService;
	@Autowired
	ProducerDAOProducerAdapter adapter;
	@Autowired
	ProducerProducerDAOAdapter adapterToDAO;
	@Override
	public Producer getProducer(Long id) {
		ProducerDAO ProducerDao = ProducerCrudService.findById(id).get();
		return this.adapter.adapt(ProducerDao);
	}

	@Override
	public List<Producer> getAllProducers() {
		
		List<ProducerDAO> ProducerList = ProducerCrudService.findAll();
		List<Producer> Producers = new ArrayList<Producer>();
        Producers = adapter.adaptList(ProducerList);
		return Producers;
	}

	@Override
	public Producer addProducer(Producer Producer) {
		
		ProducerDAO ProducerDao = adapterToDAO.adapt(Producer);
		ProducerDAO ProducerDAOResponse = ProducerCrudService.save(ProducerDao);
		return adapter.adapt(ProducerDAOResponse);
	}

	@Override
	public Producer updateProducer(Producer Producer, Long id) {
		ProducerDAO toBeUpdated = ProducerCrudService.findById(id).get();
		Producer.setId(toBeUpdated.getId());
		ProducerDAO updatedProducer = ProducerCrudService.save(this.adapterToDAO.adapt(Producer));
		
		return this.adapter.adapt(updatedProducer);
	}

	@Override
	public void deleteProducer(Long id) {
		
		ProducerCrudService.delete(id);
	}

}
