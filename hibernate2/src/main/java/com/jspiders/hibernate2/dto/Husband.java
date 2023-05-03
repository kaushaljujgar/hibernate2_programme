package com.jspiders.hibernate2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class Husband {
	@Id
	private  int id;
	private  String name;
	private  int age;
	
	@OneToOne
	Wife wife;

}
