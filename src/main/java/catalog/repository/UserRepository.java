package catalog.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import catalog.dao.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO,Long> {
	
	Optional<UserDAO> findByUsername(String name);

}
