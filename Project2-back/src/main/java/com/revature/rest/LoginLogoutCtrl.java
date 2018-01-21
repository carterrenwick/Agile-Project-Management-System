package com.revature.rest;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AsbUser;
import com.revature.service.AsbUserService;


@RestController
public class LoginLogoutCtrl 
{
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	AsbUserService userService;
	
	@GetMapping("/logout")
	public void logout()
	{
		httpSession.invalidate();
	}
	
	@PostMapping("/login")
	public AsbUser login(String username, String password)
	{
		System.out.println(username + " : " + password);
		AsbUser user = userService.validateUser(username, password);
		return user;
	}
	
	
}