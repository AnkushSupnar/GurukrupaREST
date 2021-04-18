package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankush.entities.Counter;
import com.ankush.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	@Query("select userName from Login")
	public List<String>getAllLoginNames();
	
	@Query("from Login where userName=:name")
	public Login getLoginByName(String name);

	@Query("from Login where counter=:id")
	public Counter getLoginCounter(int id);
}
