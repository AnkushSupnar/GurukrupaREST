package com.ankush.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.entities.Item;
import com.ankush.repositories.ItemRepository;

@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	private ItemRepository repository;
	@GetMapping(value="/items",produces =MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity< List<Item>>getAllItems()
	{
		return new ResponseEntity<List<Item>>(repository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/items/byid/{id}",produces =MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Item> getItemById(@PathVariable("id") long id)
	{
		Item item = repository.findById(id).orElse(null);
		if(item!=null)
		{
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/items/byname/{itemName}",produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Item>getByName(@PathVariable("itemName") String name)
	{
		Item item = repository.getItemByName(name);
		if(item!=null)
		return ResponseEntity.ok().body(item);
		else
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/items/allnames",produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<String>>getAllItemNames()
	{
		return new ResponseEntity<List<String>>(repository.getAllItemNames(),HttpStatus.OK);
	}
	@PostMapping(value="/items/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_HTML_VALUE)
	private ResponseEntity<Item>saveItem(@RequestBody Item item)
	{
		return new ResponseEntity<Item>(repository.save(item),HttpStatus.CREATED);
		
	}
	@PutMapping(value="/items/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
	private ResponseEntity<Item>updateItem(@RequestBody Item item)
	{
		if(repository.findById(item.getId())==null)
		{
			Item i=null;
			return new ResponseEntity<Item>(i,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<Item>(repository.save(item),HttpStatus.OK);
		}
	}
	
}
