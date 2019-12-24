package com.uk.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uk.shoppingbackend.dao.CategeoryDAO;
import com.uk.shoppingbackend.dto.CategeoryDTOBean;

@Repository("categeoryDAO")
@Transactional
public class CategeoryDAOImpl implements CategeoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private static List<CategeoryDTOBean> categeories = new ArrayList<>();

//	static {
//		System.out.println("CategeoryDAOImpl.enclosing_method()");
//
//		CategeoryDTOBean categeory = new CategeoryDTOBean();
//		// First Categeory
//		categeory.setId(1);
//		categeory.setName("Mobiles");
//		categeory.setDescription("I am description of Mobile Phone");
//		categeory.setImageURL("Mobile.png");
//
//		categeories.add(categeory);
//
//		// Second Categeory
//		categeory = new CategeoryDTOBean();
//		categeory.setId(2);
//		categeory.setName("Television");
//		categeory.setDescription("I am description of Television");
//		categeory.setImageURL("Television.png");

//		categeories.add(categeory);
//
//		// Third Categeory
//		categeory = new CategeoryDTOBean();
//		categeory.setId(3);
//		categeory.setName("Laptop");
//		categeory.setDescription("I am description of Laptop");
//		categeory.setImageURL("Laptop.png");

//		categeories.add(categeory);
//
//	}

	public CategeoryDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("CategeoryDAOImpl.CategeoryDAOImpl()");
	}

	@Override
	public List<CategeoryDTOBean> list() {
		System.out.println("CategeoryDAOImpl.list()");
		String selectActiveCategeory = "FROM categeory WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategeory);
		query.setParameter("active", true);
		return query.getResultList();
	}

//	Getting single categeory by id
	@Override
	public CategeoryDTOBean getCategeory(int id) {
		return sessionFactory.getCurrentSession().get(CategeoryDTOBean.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(CategeoryDTOBean categeory) {
		try {
			sessionFactory.getCurrentSession().persist(categeory);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CategeoryDTOBean categeory) {
		// TODO Auto-generated method stub
		try {
//			to update single categeory
			sessionFactory.getCurrentSession().update(categeory);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CategeoryDTOBean categeory) {
		categeory.setActive(false);
		try {
//			to update single categeory
			sessionFactory.getCurrentSession().update(categeory);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
