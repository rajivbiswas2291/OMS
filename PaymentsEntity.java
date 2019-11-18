package com.msr.oms.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payments")
public class PaymentsEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3764595870866004337L;

	private Long paymentId;

	private String transactionId;

	private Orders orders;

	private Date paymentDate;

	private String fundingSource;

	@Column(name = "funding_source")
	public String getFundingSource() {
		return fundingSource;
	}

	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "payment_id", unique = true)
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date")

	@Override
	public String toString() {
		return "PaymentsEntity [paymentId=" + paymentId + ", transactionId=" + transactionId + ", orders=" + orders
				+ ", paymentDate=" + paymentDate + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
