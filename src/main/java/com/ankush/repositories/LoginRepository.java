package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ankush.entities.Counter;
import com.ankush.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	@Query("select userName from Login")
	public List<String>getAllLoginNames();
	
	public Login findByuserName(String userName);
	
	public Login findByPerson(String person);

}
