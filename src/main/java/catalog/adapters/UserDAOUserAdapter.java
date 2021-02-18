package catalog.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import catalog.dao.UserDAO;
import models.User;

@Component
public class UserDAOUserAdapter {
	public User adapt(UserDAO user) {
		User userModel = new User();
	   if(!"".equals( user.getUsername()))  userModel.setName(user.getUsername());
	   if(!"".equals( user.getEnabled())) userModel.setEnabled(user.getEnabled());
	   if(!"".equals(user.getRole())) userModel.setRole(user.getRole());
	   if(!"".equals(user.getPassword())) userModel.setPassword(user.getPassword());
	   return userModel;
	   
	}
	
	public List<User> adaptList(List<UserDAO> userList){
		List<User> modelList = new ArrayList<User>();
		 userList.forEach(userDao -> {
			 User b = new User();
			 b = this.adapt(userDao);
			 modelList.add(b);
		 });
		 return modelList;
	}
}
