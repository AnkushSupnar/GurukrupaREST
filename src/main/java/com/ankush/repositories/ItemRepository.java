package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ankush.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("from Item where itemname=:name")
	public Item getItemByName(@Param("name") String name);
	
	@Query("select itemname from Item")
	public List<String>getAllItemNames();

	
	
}
