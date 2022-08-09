package com.db.grad.javaapi.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;

@RestController
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
			if(user!=null)
			return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
	}

	@PostMapping("/signup")
	public boolean signup(@Valid @RequestBody Map<String, String> credentials) throws Exception {

		try {
			usersRepository.addUser(Integer.parseInt(credentials.get("id")), credentials.get("name"),
					credentials.get("email"), credentials.get("role"), credentials.get("password"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
