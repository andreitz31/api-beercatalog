package catalog.crud.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalog.crud.services.UserCRUDService;
import catalog.dao.UserDAO;
import catalog.repository.UserRepository;

@Service
public class UserCRUDServiceImpl implements UserCRUDService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<UserDAO> findAll() {
		List<UserDAO> UserList = (List<UserDAO>)repository.findAll();
		return UserList;

	}

	@Override
	public Optional<UserDAO> findById(Long id) {
		Optional<UserDAO> UserDao = repository.findById(id);
		if(!UserDao.isPresent()) {
			throw  new EntityNotFoundException();
		}
		return UserDao;
	}

	@Override
	public UserDAO save(UserDAO User) {
		UserDAO UserDao = repository.save(User);
		return UserDao;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public UserDAO findByName(String name) {
		return repository.findByUsername(name).get();
	}


}
