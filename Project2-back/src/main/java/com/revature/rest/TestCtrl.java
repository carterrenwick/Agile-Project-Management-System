package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.AsbUserDao;
import com.revature.model.AsbUser;

@RestController
public class TestCtrl {
	@Autowired
	AsbUserDao userDao;
	
	
	@PostMapping("/person")
	public AsbUser makePerson(@RequestBody AsbUser U ) {
		
		return U;
	}

	@GetMapping("/C/{candy}")
	public String newReq(@PathVariable String candy ) {
		
		return "I love candy" + candy;
	}
	
	@GetMapping("/newBobbert")
	public AsbUser newReq() {
		
		AsbUser u = userDao.save(new AsbUser("Bobbert","123","Bob","Bert"));
		return u;
	}
	
	@GetMapping("/getAll")
	public List<AsbUser> getAll()
	{
		return userDao.findAll();
	}
}