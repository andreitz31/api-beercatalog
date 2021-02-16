package catalog.adapters;

import org.springframework.stereotype.Component;

import catalog.dao.ProducerDAO;
import models.Producer;

@Component
public class ProducerProducerDAOAdapter {
	
	public ProducerDAO adapt(Producer Producer) {

		ProducerDAO ProducerModel = new ProducerDAO();
	   if(!"".equals(Producer.getName())) ProducerModel.setName(Producer.getName());
	   ProducerModel.setId(Producer.getId());

	   return ProducerModel;
	   
	}

}
