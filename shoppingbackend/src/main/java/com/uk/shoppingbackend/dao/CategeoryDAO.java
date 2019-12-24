package com.uk.shoppingbackend.dao;

import java.util.List;

import com.uk.shoppingbackend.dto.CategeoryDTOBean;

public interface CategeoryDAO {
	
  List<CategeoryDTOBean> list();
  
  CategeoryDTOBean getCategeory(int id);
  
  boolean add(CategeoryDTOBean categeory);
  
  boolean update(CategeoryDTOBean categeory);
  
  boolean delete(CategeoryDTOBean categeory);
}
