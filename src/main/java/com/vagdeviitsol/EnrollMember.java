package com.vagdeviitsol;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="enrollMember")
public class EnrollMember {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	@Column(name = "gym_id")
	private int gymId;
	@Column(name = "payment_method")
	private String paymentMethod;
	@JsonFormat(pattern = "yyyy-mm-dd",shape = Shape.STRING)
	@Column(name = "doj")
	private Date doj;
	@Column(name = "plan_type ")
	private int planType;
	
	public long getUserId() {
		return user_id;
	}
	public void setUserId(long memberId) {
		this.user_id = memberId;
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gym_id) {
		this.gymId = gym_id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String payment_method) {
		this.paymentMethod = payment_method;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public int getPlanType() {
		return planType;
	}
	public void setPlanType(int planType) {
		this.planType = planType;
	}
	

}
