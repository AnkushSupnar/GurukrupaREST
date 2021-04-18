package com.ankush.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity

public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(nullable = false)
	String userName;
	@Column(nullable = false)
	String password;
	
	@ManyToOne
	@JoinColumn(name="counterId")
	Counter counter;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userName, String password, Counter counter) {
		super();
		this.userName = userName;
		this.password = password;
		this.counter = counter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Counter getCounter() {
		return counter;
	}
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", password=" + password + ", counter=" + counter + "]";
	}
	
}
