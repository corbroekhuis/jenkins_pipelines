package com.academy.docker.model;

import javax.persistence.*;

@Entity
public class Employee{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	private String email;
	private long bsn;
	private String imageUrl;

	public Employee() {
		System.out.println( "");
	}




	public Employee(long id, String name, int age, String email, long bsn, String imageUrl) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.bsn = bsn;
		this.imageUrl = imageUrl;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public String getName(){ 
		return name;
	}
	public void setName( String name){
		this.name = name;
	}
	public int getAge(){ 
		return age;
	}
	public void setAge( int age){
		this.age = age;
	}
	public String getEmail(){ 
		return email;
	}
	public void setEmail( String email){
		this.email = email;
	}

	public long getBsn() {
		return bsn;
	}

	public void setBsn(long bsn) {
		this.bsn = bsn;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
