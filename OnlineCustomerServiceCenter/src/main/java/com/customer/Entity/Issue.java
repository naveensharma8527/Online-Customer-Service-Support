package com.customer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer issueId;
	@NotBlank(message = "Issue cannot be Blank")
	@NotEmpty(message = "Issue cannot be Empty")
	@NotNull(message = "Issue cannot be Null")
	private String issueType;
	@Size(min = 10, max = 200, message = "Description size should be between 10 and 200 characters")
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "call_id")
	private Call call;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name= "solution_id")
	private Solution solution;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name= "customer_id")
	private Customer customer;
	public Issue()
	{
		
	}
	public Issue(Integer issueId,
			@NotBlank(message = "Issue cannot be Blank") @NotEmpty(message = "Issue cannot be Empty") @NotNull(message = "Issue cannot be Null") String issueType,
			@Size(min = 10, max = 200, message = "Description size should be between 10 and 200 characters") String description,
			Status status, Call call, Solution solution, Customer customer) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.description = description;
		this.status = status;
		this.call = call;
		this.solution = solution;
		this.customer = customer;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Call getCall() {
		return call;
	}
	public void setCall(Call call) {
		this.call = call;
	}
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueType=" + issueType + ", description=" + description + ", status="
				+ status + ", call=" + call + ", solution=" + solution + "]";
	}
	
	
}
