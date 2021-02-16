package catalog.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import catalog.dao.ProducerDAO;
import models.Producer;

@Component
public class ProducerDAOProducerAdapter {
	
	public Producer adapt(ProducerDAO Producer) {
		Producer ProducerModel = new Producer();
	   if(!"".equals(Producer.getName())) ProducerModel.setName(Producer.getName());
	   ProducerModel.setId(Producer.getId());
	   return ProducerModel;
	   
	}
	
	public List<Producer> adaptList(List<ProducerDAO> ProducerList){
		List<Producer> modelList = new ArrayList<Producer>();
		 ProducerList.forEach(ProducerDao -> {
			 Producer b = new Producer();
			 b = this.adapt(ProducerDao);
			 modelList.add(b);
		 });
		 return modelList;
	}

}
