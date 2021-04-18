package com.ankush.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.entities.Counter;
import com.ankush.entities.Login;
import com.ankush.repositories.LoginRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginRepository repository;

	@GetMapping(value = "/logins", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Login>> getAllLogin() {
		return new ResponseEntity<List<Login>>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/logins/byname/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Login> getLoginByName(@PathVariable("userName") String name) {
		Login login = repository.getLoginByName(name);
		if (login != null)
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		else
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/logins/byid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Login> getLoginById(@PathVariable("id") int id) {
		Login login = repository.findById(id).orElse(null);
		if (login != null)
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		else
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/logins/getcounter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Counter> getLoginCounter(int id) {
		Counter counter = repository.getLoginCounter(id);
		if (counter != null)
			return new ResponseEntity<Counter>(counter, HttpStatus.OK);
		else
			return new ResponseEntity<Counter>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/logins/validate/{userName}/{password}")
	private ResponseEntity<String> validateLogin(@PathVariable("userName") String name,
			@PathVariable("password") String password) {
		Login login = new Login();
		login = repository.getLoginByName(name);
		if (login == null) {
			return new ResponseEntity<String>("Enter Correct User Name!!!", HttpStatus.BAD_REQUEST);
		}

		else if (!login.getPassword().equals(password)) {
			return new ResponseEntity<String>("Enter Correct Password!!!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Login Success!!!", HttpStatus.OK);
		}
	}

	@PostMapping(value = "/logins/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Login> saveLogin(@RequestBody Login login) {
		return new ResponseEntity<Login>(repository.save(login), HttpStatus.OK);
	}

}
