package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankush.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("from Item where itemName=:name")
	public Item getItemByName(String name);
	
	@Query("select itemName from Item")
	public List<String>getAllItemNames();

	
	
}
