package catalog.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import catalog.adapters.UserUserDAOAdapter;
import catalog.adapters.UserDAOUserAdapter;
import catalog.crud.services.UserCRUDService;
import catalog.dao.UserDAO;
import catalog.dao.ProducerDAO;
import catalog.services.UserService;
import models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserCRUDService UserCrudService;
	@Autowired
	UserDAOUserAdapter adapter;
	@Autowired
	UserUserDAOAdapter adapterToDAO;
	@Override
	public User getUser(Long id) {
		
		UserDAO UserDao;
		try {
			UserDao = UserCrudService.findById(id).get();
		} catch (Exception e) {
			UserDao = new UserDAO();
		}
		
		return this.adapter.adapt(UserDao);
	}

	@Override
	public List<User> getAllUsers() {
		
		List<UserDAO> UserList = UserCrudService.findAll();
		List<User> Users = new ArrayList<User>();
        Users = adapter.adaptList(UserList);
		return Users;
	}

	@Override
	public User addUser(User User)  {
		
		UserDAO UserDao = adapterToDAO.adapt(User);
		UserDAO UserDAOResponse = UserCrudService.save(UserDao);
		return adapter.adapt(UserDAOResponse);
	}



	@Override
	public void deleteUser(Long id) {
		
		UserCrudService.delete(id);
	}

}
