
package com.infinite.ins;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



public class InsuranceDAO {
	SessionFactory sessionFactory;
	
public String generatePaymentId() {
		
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Payment.class);
		java.util.List<Payment> roomlist = cr.list();
		session.close();
		
		if(roomlist.size()==0) {
			return "Q001";
		}
		else {
		String id = roomlist.get(roomlist.size()-1).getBookingId();
		int id1 = Integer.parseInt(id.substring(1));
		id1++;
		String id2 = String.format("Q%03d", id1);
		return id2;
		}
	}

	
	//SearchpolicyId from policy table
	
	public Policy searchById(String policyId) {
		sessionFactory = SessionHelper.getConnection();
  		Session session = sessionFactory.openSession(); 
  		Criteria cr = session.createCriteria(Policy.class);
  		cr.add(Restrictions.eq("policyId", policyId));
  		List<Policy> PolicyList = cr.list();
  		return PolicyList.get(0);
	}
	
	//searchBookingID from booking table
	public BookingDetails searchBookId(String bid) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(BookingDetails.class);
		criteria.add(Restrictions.eq("bookingId", bid));
		java.util.List<BookingDetails> BookIdlist = criteria.list();
		return BookIdlist.get(0);
	}
	
	//searchBookingID from paymentTable
	public List<Payment> searchPaymentBookId(String bid) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("bookingId", bid));
		java.util.List<Payment> BookIdlist = criteria.list();
		return BookIdlist;
	}
	
	//AmmountleftCalculation
	public double amountLeftInTerm(double premiumAmount,double totalAmountPaidInTerm,String bookId){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(Payment.class);
		Customer customer=new Customer();
		Policy policy=new Policy();
		Payment payment=new Payment();
		BookingDetails booking=new BookingDetails();
		
		List<Payment> paymentList = searchPaymentBookId(bookId);
		
		if(paymentList.size()==0){
			double amountLeftInTerm1=policy.getPremiumAmount()-payment.getTotalAmountToPayInEveryMode();
			return amountLeftInTerm1;
			// payment.setAmountLeftInTerm(amountLeftInTerm1);
		}else{
			String id = paymentList.get(paymentList.size()-1).getBookingId();
			double amountLeftInTerm2=payment.getAmountLeftInTerm()-payment.getTotalAmountToPayInEveryMode();
			 //payment.setAmountLeftInTerm(amountLeftInTerm2);
			return amountLeftInTerm2; 
		}
		
	}
	
	//TotalAmountToPayInEveryMode
	public double totalAmountToPayInEveryMode(double totalAmountToPayInEveryMode){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Policy policy=new Policy();
		double totalAmountToPayInEveryMode1=policy.getInstallmentAmountPerPayMode();
		return totalAmountToPayInEveryMode1;
	}
	//nextPAyment
	public Date nextDatepayment(Date nextpayment){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		java.util.Date date= new java.util.Date();
		Policy policy= new Policy();
		Payment payment= new Payment();
		//Calendar cal = Calendar.getInstance();
		//cal.setTime(date);
		java.util.Date nextpay=new Date(date.getTime());
		Calendar calendar = Calendar.getInstance();
		
		if(policy.getPayMode()=="QUATERLY"){
//			Date nextpay=new Date(date.getTime());
//			Calendar calendar = Calendar.getInstance();
		       //System.out.println("Current Date = " + calendar.getTime());
		      // Add 3 months to the Calendar
			nextpay= calendar.getTime();
			calendar.add(Calendar.MONTH, 3);
		  payment.setNextDayPayment(nextpay);
			
		}else if(policy.getPayMode()=="HALFYEARLY"){
			nextpay= calendar.getTime();
			calendar.add(Calendar.MONTH, 6);
		   payment.setNextDayPayment(nextpay); 
		}else if(policy.getPayMode()=="YEARLY"){
			nextpay= calendar.getTime();
			calendar.add(Calendar.MONTH, 12);
		   payment.setNextDayPayment(nextpay);
		}else{
			
		}
		return nextpayment;
		
	}
	
	//finecalculation
	public double fine(double fine){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Customer customer=new Customer();
		Policy policy=new Policy();
		Payment payment=new Payment();
		long paydate=payment.getPaymentDate().getTime();
		long nextpayDate=payment.getNextDayPayment().getTime();
		double fine1=0;
		if(paydate > nextpayDate){
//		double payAmt=policy.getInstallmentAmountPerPayMode();
			double fine2=100;
			fine2=fine1+fine2;
		}
		return fine;
		

	}
	
	//paymentAmount Calculation
	
	public double paymentAmout(double paymentAmount,String bookId,double fine){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(Payment.class);
		Customer customer=new Customer();
		Policy policy=new Policy();
		Payment payment=new Payment();
		fine(fine);
		
		BookingDetails booking=new BookingDetails();
		List<Payment> paymentList = searchPaymentBookId(bookId);
		if(paymentList.size()==0){
			long paydate=payment.getPaymentDate().getTime();
			long nextpayDate=payment.getNextDayPayment().getTime();
			
			if(paydate < nextpayDate){
			double paymentAmount1=policy.getInstallmentAmountPerPayMode();
			return paymentAmount1;
		}
		}else{
			String id = paymentList.get(paymentList.size()-1).getBookingId();
			
			double payAmount=policy.getInstallmentAmountPerPayMode()+fine;
			return payAmount;
			
		}
	
	 return paymentAmount;
	}
	
	//nextPayDate
	
	
	//MakePayment
	public String addPayments(Payment payment){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		
		String payId=generatePaymentId();
		payment.setPaymentntId(payId);
		
		Criteria cr=session.createCriteria(Payment.class);
		Customer customer=new Customer();
		Policy policy=new Policy();
		BookingDetails booking=new BookingDetails();
		
//		String custId=booking.getCustomerId();
		payment.setCustomerId(payment.getCustomerId());
		
		String bookid=payment.getBookingId();
		String pId=   payment.getPolicyId();
		policy=searchById(pId);
	 
		double alt=amountLeftInTerm(policy.getPremiumAmount(), payment.getTotalAmountToPayInEveryMode(), payment.getBookingId());
		payment.setAmountLeftInTerm(alt);
		
		double totalAmtEvryMode=totalAmountToPayInEveryMode(policy.getInstallmentAmountPerPayMode());
		payment.setTotalAmountToPayInEveryMode(totalAmtEvryMode);
		
		
		org.hibernate.Transaction transaction=session.beginTransaction();
		session.save(payment);
		transaction.commit();
		session.close();
		return "Payment done successfully....";
		
		
		}
	
	
}