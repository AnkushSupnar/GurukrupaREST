package com.ankush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ankush.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

		
	@Query("select bankname from Bank")
	public List<String>getAllBankNames();
	
	@Query("select balance from Bank where id=:id")
	public double getBankBalance(@Param("id") int id);
	
	@Query("update Bank set balance=balance+:balance where id=id")
	public int addBankBalance(@Param("id") int id,@Param("balance")double balance);
	
	@Query("update Bank set balance=balance-:balance where id=:id")
	public int resuceBankBalance(@Param("id")int id,@Param("balance") double balance);
	
}
