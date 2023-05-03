package com.jspiders.hibernate2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Wife {
	@Id
	private  int id;
	private  String name;
	private  int age;
}
