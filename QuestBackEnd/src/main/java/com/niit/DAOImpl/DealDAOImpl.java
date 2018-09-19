package com.niit.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.DealDAO;
import com.niit.Model.Deal;
@Repository(value="dealDAO")
@Transactional
public class DealDAOImpl implements DealDAO {
	@Autowired
SessionFactory sessionfactory;
	
	
	public boolean addDeal(Deal deal) {
		
sessionfactory.getCurrentSession().save(deal);
   return true;
	}
	
	public void ViewDeal() {
	List<Deal> deal=sessionfactory.getCurrentSession().createQuery("from Deal").list();
	for(Deal de:deal)
	{
		System.out.println(de.getDid());
		System.out.println(de.getDname());
		System.out.println(de.getDdescription());
		
	}
	}
	
	  public Deal findDealById(String did) {
			
			return (Deal)sessionfactory.getCurrentSession().createQuery("from Deal where did='"+did+"'").uniqueResult();
		}
		
		public boolean updateDeal(Deal deal) {
			sessionfactory.getCurrentSession().update(deal);
			return true;
		}
		
		public boolean deleteDeal(String did) {
			sessionfactory.getCurrentSession().delete(findDealById(did));	
			return true;
		
		}
}