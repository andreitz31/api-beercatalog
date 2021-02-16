package catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import catalog.dao.ProducerDAO;

@Repository
public interface ProducerRepository extends CrudRepository<ProducerDAO,Long> {

}
