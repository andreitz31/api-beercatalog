package catalog.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import catalog.dao.ProducerDAO;

@Repository
public interface ProducerRepository extends CrudRepository<ProducerDAO,Long> {
	
	Optional<ProducerDAO> findByName(String name);

}
