package catalog.services;

import java.util.List;


import models.User;

public interface UserService   {
	public User getUser(Long id);
	public List<User> getAllUsers();
	public User addUser(User User);
	public void deleteUser(Long id);

}
