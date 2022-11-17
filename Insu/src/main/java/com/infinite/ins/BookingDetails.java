package com.infinite.ins;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BookingDetails")
public class BookingDetails {
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", customerId=" + customerId + ", policyID=" + policyID
				+ ", payMode=" + payMode + ", bookingDate=" + bookingDate + ", expiryDate=" + expiryDate + ", status="
				+ status + "]";
	}

	@Id
	@Column(name="BookingId")
	private String bookingId ;
	
	@Column(name="CustomerId")
	private String customerId ;
	
	@Column(name="PolicyID")
	private String policyID ;
	
	@Column(name="PayMode")
	private String payMode; 
	
	@Column(name="BookingDate")
	private Date bookingDate;
	
	@Column(name="ExpiryDate")
	private Date expiryDate;
	
	@Column(name="Status")
	@Enumerated(EnumType.STRING)
	private Status status;

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

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}