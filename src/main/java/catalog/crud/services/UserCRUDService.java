package catalog.crud.services;

import java.util.List;
import java.util.Optional;

import catalog.dao.UserDAO;

public interface UserCRUDService {
	List<UserDAO> findAll();
	Optional<UserDAO> findById(Long id);
	UserDAO save(UserDAO User);
	void delete(Long id);
	UserDAO findByName(String name);
}
