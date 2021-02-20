package catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import catalog.dao.BeerDAO;

@Repository
public interface BeerRepository extends CrudRepository<BeerDAO,Long> {
	
	List<BeerDAO> findByProducer(String producer);
	List<BeerDAO> findByType(String type);

}
