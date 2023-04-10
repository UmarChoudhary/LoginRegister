package net.app.registration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import net.app.registration.model.User;

import net.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {

private RegistrationService service;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && "".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if (userobj != null) {
				throw new Exception("user with"+tempEmailId+"is already exist");
			}
		}
		User userobj = null;
		userobj = service.saveUser(user);
		return userobj;
	}
	@PostMapping("/loginuser")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userobj = null;
		if (tempEmailId != null && tempPass != null) {
			service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if (userobj == null) {
			throw new Exception("Bad Credentials");
	}
		return userobj;
	}
}