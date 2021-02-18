package catalog.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import catalog.dao.UserDAO;
import models.User;

@Component
public class UserUserDAOAdapter {
	public UserDAO adapt(User user) {

		UserDAO userModel = new UserDAO();

	   if(!"".equals(user.getName())) userModel.setUsername(user.getName());
	   if(!"".equals(user.getEnabled())) userModel.setEnabled(user.getEnabled());
	   if(!"".equals(user.getRole())) userModel.setRole(user.getRole());
	   if(!"".equals(user.getPassword())) userModel.setPassword(user.getPassword());
	   
	   
	   

	   return userModel;
	   
	}
}
