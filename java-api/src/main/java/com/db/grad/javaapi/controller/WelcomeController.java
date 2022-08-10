package com.db.grad.javaapi.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/")
	public String getWelcome() {
		return "Dogs API is up and running!";
	}

	@PostMapping("/login")
	public boolean login(@Valid @RequestBody Map<String, String> credentials) throws Exception {

		try {
			Users user=usersRepository.checkLogin(credentials.get("email"), credentials.get("password"));
			System.out.println(user);
			if(user!=null)
				return true;
			else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Credentials");
		} catch (Exception e) {
			return false;
		}
	}

	@PostMapping("/signup")
	public boolean signup(@Valid @RequestBody Map<String, String> credentials) throws Exception {

		try {
			int count=usersRepository.getCount();
			
			Users user=usersRepository.addUser(count+1, credentials.get("email").substring(0,5),
					credentials.get("email"), credentials.get("role"), credentials.get("password"));
			if(user!=null)
			return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
	}
}
