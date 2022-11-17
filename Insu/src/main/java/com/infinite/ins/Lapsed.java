package com.infinite.ins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lapseddetails")
public class Lapsed {
	@Id
	@Column(name="loanId")
	private String loanId;
	@Column(name="policyId")
	private String policyId;
	@Column(name="lapsedAmount")
	private double lapsedAmount;
	@Column(name="refundAmount")
	private double refundAmount;
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public double getLapsedAmount() {
		return lapsedAmount;
	}
	public void setLapsedAmount(double lapsedAmount) {
		this.lapsedAmount = lapsedAmount;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

}
