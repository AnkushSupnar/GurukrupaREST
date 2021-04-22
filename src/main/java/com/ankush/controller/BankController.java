package com.ankush.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.entities.Bank;
import com.ankush.repositories.BankRepository;

@RestController
@RequestMapping(value = "/api")
public class BankController {

	@Autowired
	private BankRepository repository;

	@GetMapping
	private ResponseEntity<String> checkConnection() {
		return new ResponseEntity<String>("Connected", HttpStatus.OK);
	}

	@GetMapping(value="/banks/byid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Bank> getBankById(@RequestBody int id) {
		Bank bank = repository.findById(id).orElse(null);
		if (bank != null)
			return new ResponseEntity<Bank>(bank, HttpStatus.OK);
		else
			return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/banks",produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Bank>>getAllBanks()
	{
		return new ResponseEntity<List<Bank>>(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping(value="/banks/allbanknames",produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<String>>getAllBankNames()
	{
		return new ResponseEntity<List<String>>(repository.getAllBankNames(),HttpStatus.OK);
	}
	@GetMapping(value="/banks/getbalance/{id}")
	private ResponseEntity<Double>getBankBalance(@RequestBody int id)
	{
		return new ResponseEntity<Double>(repository.getBankBalance(id),HttpStatus.OK);
	}
	@PutMapping(value="/banks/addbalance/{id}/{balance}")
	private ResponseEntity<Integer>addBankBalance(@RequestBody int id,@RequestBody double balance)
	{
		return new ResponseEntity<Integer>(repository.addBankBalance(id, balance),HttpStatus.OK);
	}
	@PutMapping(value="/banks/reducebalance/{id}/{balance}")
	private ResponseEntity<Integer>reduceBankBalance(@RequestBody int id,@RequestBody double balance)
	{
		return new ResponseEntity<Integer>(repository.resuceBankBalance(id, balance),HttpStatus.OK);
	}
	@PostMapping(value="/banks/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Bank>saveBank(@RequestBody Bank bank)
	{
		return new ResponseEntity<Bank>(repository.save(bank),HttpStatus.OK);
	}
	@PutMapping(value="/banks/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Bank>updateBank(@RequestBody Bank bank)
	{
		Bank b = repository.findById(bank.getId()).orElse(null);
		if(b!=null)
			return new ResponseEntity<Bank>(repository.save(bank),HttpStatus.OK);
		else
			return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
	}
}