package com.infinite.ins;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerDAO {
	
	
	SessionFactory sessionFactory;
	
//	public int loginCheck(String username, String password) {
//		sessionFactory = SessionHelper.getConnection();
//		Session session = sessionFactory.openSession();
//		
//		Criteria criteria = session.createCriteria(Insuranceusers.class);
//		criteria.add(Restrictions.eq("username", username));
//		criteria.add(Restrictions.eq("password", password));
//		List<Insuranceusers> listUsers = criteria.list();
//		return listUsers.size();
//	}
	
	public List<Customer> showCustomer(){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
	//	Criteria cr=session.createCriteria(Customer.class);
		Query query=session.createQuery("from Customer");
		List<Customer> customerList=query.list();
		return customerList;
			}
	
	public String addcustomer(Customer customer) {
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		return "Customer Added...";
		
   }
	
   public String updateCustomer(Customer customer ){
	   sessionFactory=SessionHelper.getConnection();
	   Session session=sessionFactory.openSession();
	   Transaction transaction = session.beginTransaction();
	   session.saveOrUpdate(customer);
	   transaction.commit();
		
	   return "Update Customer";
   }
   
   public Customer searchCustomerById(String customerId) {
	   sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("customerId", customerId));
		List<Customer> cutlist=cr.list();
		return cutlist.get(0);
		//Transaction tr=session.beginTransaction();
	 
   }
   
   public String DeleteCustomer(String customerId){
	   sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Customer cust=searchCustomerById(customerId);
		Transaction tr=session.beginTransaction();
		session.delete(cust);
		tr.commit();
		return "deleted";
		
   }

}