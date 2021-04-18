package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ankush.entities.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer> {

	@Query("from Counter where counterName=:name")
	public Counter getCounterByName(String name);
	
	@Query("select counterName from Counter")
	public List<String>getAllCounterNames();
	
}
