package com.uk.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uk.shoppingbackend.dao.CategeoryDAO;
import com.uk.shoppingbackend.dto.CategeoryDTOBean;

@Repository("categeoryDAO")
public class CategeoryDAOImpl implements CategeoryDAO {
	private static List<CategeoryDTOBean> categeories = new ArrayList<>();

	static {
		System.out.println("CategeoryDAOImpl.enclosing_method()");

		CategeoryDTOBean categeory = new CategeoryDTOBean();
		// First Categeory
		categeory.setId(1);
		categeory.setName("Mobiles");
		categeory.setDescription("I am description of Mobile Phone");
		categeory.setImageURL("Mobile.png");

		categeories.add(categeory);

		// Second Categeory
		categeory = new CategeoryDTOBean();
		categeory.setId(2);
		categeory.setName("Television");
		categeory.setDescription("I am description of Television");
		categeory.setImageURL("Television.png");

		categeories.add(categeory);

		// Third Categeory
		categeory = new CategeoryDTOBean();
		categeory.setId(3);
		categeory.setName("Laptop");
		categeory.setDescription("I am description of Laptop");
		categeory.setImageURL("Laptop.png");

		categeories.add(categeory);

	}

	public CategeoryDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("CategeoryDAOImpl.CategeoryDAOImpl()");
	}

	@Override
	public List<CategeoryDTOBean> list() {
		return categeories;
	}

	@Override
	public CategeoryDTOBean getCategeory(int id) {
		// TODO Auto-generated method stub
		// enhance for llop
		for (CategeoryDTOBean categeory : categeories) {

			if (categeory.getId() == id) {
				return categeory;
			}

		}
		return null;
	}

}
