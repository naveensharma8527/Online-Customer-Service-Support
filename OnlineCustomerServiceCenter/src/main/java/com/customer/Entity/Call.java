package com.customer.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CallData")
public class Call {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate callDate;
	private Double duration;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name= "issue_id")
	private Issue issue;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="operator_id")
	private Operator operator;
	public Call()
	{
		
	}
	public Call(Integer callId, LocalDate callDate, Double duration, Customer customer, Issue issue,
			Operator operator) {
		super();
		this.callId = callId;
		this.callDate = callDate;
		this.duration = duration;
		this.customer = customer;
		this.issue = issue;
		this.operator = operator;
	}
	public Integer getCallId() {
		return callId;
	}
	public void setCallId(Integer callId) {
		this.callId = callId;
	}
	public LocalDate getCallDate() {
		return callDate;
	}
	public void setCallDate(LocalDate callDate) {
		this.callDate = callDate;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Call(Integer callId, LocalDate callDate, Double duration, Customer customer) {
		super();
		this.callId = callId;
		this.callDate = callDate;
		this.duration = duration;
		this.customer = customer;
	}
	
	
	
	
}
