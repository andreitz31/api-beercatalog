package catalog.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalog.services.UserService;
import io.swagger.annotations.ApiOperation;
import models.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get User", notes= "This method gets the information of a User")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		ResponseEntity<User> response;
			User user = UserService.getUser(id);
			response = ResponseEntity.accepted().body(user);

		return response;
	}
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/")
	@ApiOperation(value = "List Users", notes= "This method gets the information of all Users")
	public ResponseEntity<List<User>> listUser(){
		ResponseEntity<List<User>> response;
		try {
			List<User> userList = UserService.getAllUsers();
			response = ResponseEntity.accepted().body(userList);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/addUser")
	@ApiOperation(value = "Add User", notes= "This method adds the information of a User")
	public ResponseEntity<User> addUser(@RequestBody User user){
		ResponseEntity<User> response;
			User userResponse = UserService.addUser(user);
			response = ResponseEntity.accepted().body(userResponse);
	
		return response;
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@ApiOperation(value = "Delete User", notes= "This method deletes the information of a User")
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		ResponseEntity<User> response;
		try {
			UserService.deleteUser(id);
			response = ResponseEntity.accepted().build();
		} catch (Exception e) {
			response = ResponseEntity.badRequest().build();
		}
		return response;
		
	}
	
    @GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }

}
