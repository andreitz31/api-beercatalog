package catalog.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import catalog.dao.UserDAO;
import models.User;

@Component
public class UserUserDAOAdapter {
	public UserDAO adapt(User user) {

		UserDAO userModel = new UserDAO();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	   if(!"".equals(user.getName())) userModel.setUsername(user.getName());
	   if(!"".equals(user.getEnabled())) userModel.setEnabled(user.getEnabled());
	   if(!"".equals(user.getRole())) userModel.setRole(user.getRole());
	   if(!"".equals(user.getPassword())) userModel.setPassword(encoder.encode(user.getPassword()));
	   
	   
	   

	   return userModel;
	   
	}
}
