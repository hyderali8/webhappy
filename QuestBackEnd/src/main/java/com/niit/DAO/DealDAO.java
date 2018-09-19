package com.niit.DAO;

import com.niit.Model.Deal;
 
public interface DealDAO {
public boolean addDeal(Deal deal);	
public void ViewDeal();
public Deal findDealById(String did);
public boolean updateDeal(Deal deal);
public boolean deleteDeal(String did);


}