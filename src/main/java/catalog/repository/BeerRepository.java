package catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import catalog.dao.BeerDAO;

@Repository
public interface BeerRepository extends CrudRepository<BeerDAO,Long> {

}
