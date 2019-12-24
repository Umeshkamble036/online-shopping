package com.uk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.uk.shoppingbackend.dao.CategeoryDAO;
import com.uk.shoppingbackend.dto.CategeoryDTOBean;

public class CategeoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategeoryDAO categeoryDAO;

	private CategeoryDTOBean categeory;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.uk.shoppingbackend");
		context.refresh();

		categeoryDAO = (CategeoryDAO) context.getBean("categeoryDAO");
	}

//	@Test
//	public void testAddCategeory() {
//
//		categeory = new CategeoryDTOBean();
//		categeory.setName("Laptop");
//		categeory.setDescription("I am description of Laptop");
//		categeory.setImageURL("Laptop.png");
//		System.out.println(categeory);
//		assertEquals("Succesfully added a categeory inaside a table", true, categeoryDAO.add(categeory));
//
//	}

//	@Test
//	public void testAddCategeory() {
//
//		categeory = categeoryDAO.getCategeory(13);
//		System.out.println(categeory);
//		assertEquals("Succesfully get categeory from a table", "Laptop", categeory.getName());
//		
//
//	}

//	@Test
//	public void testUpdateCategeory() {
//
//		categeory = categeoryDAO.getCategeory(13);
//		categeory.setName("Lappy");
//		assertEquals("Succesfully updated categeory in a table",true, categeoryDAO.update(categeory));
//	}

//	@Test
//	public void testDeleteCategeory() {
//
//		categeory = categeoryDAO.getCategeory(13);
//		assertEquals("Succesfully deleted single categeory in a table", true, categeoryDAO.delete(categeory));
//	}

//	@Test
//	public void testListCategeory() {
//		assertEquals("Succesfully fetched list of categeory from a table", 2, categeoryDAO.list().size());
//	}
	
	@Test
	public void testCRUDOperation() {
		
		categeory = new CategeoryDTOBean();
		categeory.setName("Laptop");
		categeory.setDescription("I am description of Laptop");
		categeory.setImageURL("Laptop.png");
		
		assertEquals("Successfully added Laptop Categeory",true,categeoryDAO.add(categeory));
		
		categeory = new CategeoryDTOBean();
		categeory.setName("Clothes");
		categeory.setDescription("I am description of Clothes");
		categeory.setImageURL("Clothes.png");
		
		assertEquals("Successfully added Clothes Categeory",true,categeoryDAO.add(categeory));
		
		
		//fetching and updating categeory
		categeory=categeoryDAO.getCategeory(1);
		categeory.setName("LAPPYY");
		
		assertEquals("Successfully Update Categeory",true,categeoryDAO.update(categeory));
		
		//delete the categeory
		assertEquals("Successfully Update Categeory",true,categeoryDAO.delete(categeory));
		
		//list the query
		assertEquals("Succesfully fetched list of categeory from a table",1, categeoryDAO.list().size());
	}

}
