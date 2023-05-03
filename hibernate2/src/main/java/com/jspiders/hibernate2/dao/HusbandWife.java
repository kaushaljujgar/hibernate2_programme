package com.jspiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import com.jspiders.hibernate2.dto.Husband;
import com.jspiders.hibernate2.dto.Wife;

public class HusbandWife {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("OneToOne");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory !=null) {
			factory.close();
		}
		if (manager !=null) {
			manager.close();
		}
		if (transaction.isActive() ) {
			transaction.rollback();
		}
		
		
		
	}
	public static void main(String[] args) {
		openConnection();
		transaction.begin();
		
		Wife wife1=new Wife();
		wife1.setId(2);
		wife1.setName("Daya");
		wife1.setAge(35);
		manager.persist(wife1);
		
		Husband husband1=new Husband();
		husband1.setId(2);
		husband1.setName("Jethalal");
		husband1.setAge(45);
		husband1.setWife(wife1);
		
		manager.persist(husband1);
		
		Wife wife3=new Wife();
		wife3.setId(3);
		wife3.setName("Roshini");
		wife3.setAge(35);
		manager.persist(wife3);
		
		Husband husband3=new Husband();
		husband3.setId(3);
		husband3.setName("Jethalal");
		husband3.setAge(45);
		husband3.setWife(wife3);
		
		manager.persist(husband3);
		
		transaction.commit();
		closeConnection();
		
		
		
		
	}
}
