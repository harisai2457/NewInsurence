package com.infinite.ins;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="paymentdetails")
public class Payment {
	@Id
	@Column(name="PaymentntId")
	private String paymentntId ;
	
	@Column(name="BookingId")
	 private String bookingId ;
	
	@Column(name="CustomerId")
	 private String customerId ;
	
	@Column(name="PolicyId")
	 private String policyId ;
	
	@Column(name="AmountLeftInTerm")
	 private double amountLeftInTerm ;
	
	@Column(name="TotalAmountToPayInEveryMode")
	 private double totalAmountToPayInEveryMode ;
	

	@Column(name="PayAmount")
	 private double payAmount ;
	
	@Column(name="Fine")
	private double fine;
	
	@Column(name="PaymentDate")
	 private Date paymentDate;
	
	@Column(name="NextDayPayment")
	 private Date nextDayPayment;
	
	
	public String getPaymentntId() {
		return paymentntId;
	}

	public void setPaymentntId(String paymentntId) {
		this.paymentntId = paymentntId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public double getAmountLeftInTerm() {
		return amountLeftInTerm;
	}

	public void setAmountLeftInTerm(double amountLeftInTerm) {
		this.amountLeftInTerm = amountLeftInTerm;
	}

	public double getTotalAmountToPayInEveryMode() {
		return totalAmountToPayInEveryMode;
	}

	public void setTotalAmountToPayInEveryMode(double totalAmountToPayInEveryMode) {
		this.totalAmountToPayInEveryMode = totalAmountToPayInEveryMode;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getNextDayPayment() {
		return nextDayPayment;
	}

	public void setNextDayPayment(Date nextDayPayment) {
		this.nextDayPayment = nextDayPayment;
	}



	
	
	
	
	
}