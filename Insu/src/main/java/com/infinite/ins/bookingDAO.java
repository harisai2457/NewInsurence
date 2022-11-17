package com.infinite.ins;

import java.sql.Date;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;




public class bookingDAO {

    SessionFactory sessionFactory;
    Session session;
    
    
    public List<BookingDetails> showBooking() {
        sessionFactory = SessionHelper.getConnection();
          Session session=sessionFactory.openSession();
          
          Criteria cr = session.createCriteria(BookingDetails.class);
        //  cr.add(Restrictions.eq("status", Status.ACTIVE));
          List<BookingDetails> bookingList =cr.list() ;
          return bookingList;
}
    private String generateBookingId() {
        sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(BookingDetails.class);
        List<BookingDetails> bookingList = criteria.list();
        if(bookingList.size()==0){
            return "B001";
        }else{
        String bookingId = bookingList.get(bookingList.size()-1).getBookingId();
        bookingId = String.format("%03d", Integer.parseInt(bookingId.substring(1))+1);
        bookingId = "B"+  bookingId;
        
        return bookingId;}
    }
    
    
    public String addBooking(BookingDetails booking) {
        
        sessionFactory=SessionHelper.getConnection();
        session=sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
       String bookingId=generateBookingId();
//       System.out.println(bookingId);
//       System.out.println("Policy Id " +booking.getPolicyID());
//       System.out.println(booking.getCustomerId());
//       System.out.println(booking.getPaymode());
        booking.setBookingId(bookingId);
        booking.setStatus(Status.ACTIVE);
        Calendar calendar = Calendar.getInstance();  
        java.util.Date date=calendar.getTime();
        java.sql.Date bookingDate=new Date(date.getTime());
        booking.setBookingDate(bookingDate);
        
        Policy policyDetails=searhByPolicyId(booking.getPolicyID());
        int term=Integer.parseInt(policyDetails.getTerm());
         calendar.add(Calendar.YEAR, term);
         java.util.Date date2=calendar.getTime();
         java.sql.Date exDate=new Date(date2.getTime());
         booking.setExpiryDate(exDate);
        session.save(booking);
        tr.commit();
        session.close();
        return "booking Added...";
   }
    
//searchPolicy
    public Policy searhByPolicyId(String policyId) {
        sessionFactory= SessionHelper.getConnection();
          Session session = sessionFactory.openSession();
          Criteria cr = session.createCriteria(Policy.class);
          cr.add(Restrictions.eq("policyId", policyId));
          List<Policy> bookList = cr.list();
          System.out.println(bookList.size());
          return bookList.get(0);
    }
    
    //
}
    