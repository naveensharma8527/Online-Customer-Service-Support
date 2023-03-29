package com.customer.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer solutionId;
	@Size(min = 10, max = 200, message = "Description size should be between 10 and 200 characters")
	private String description;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="issue_id")
	private Issue issue;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="operator_id")
	private Operator operator;
	public Solution()
	{
		
	}
	public Solution(Integer solutionId,
			@Size(min = 10, max = 200, message = "Description size should be between 10 and 200 characters") String description,
			LocalDate date, Issue issue, Operator operator) {
		super();
		this.solutionId = solutionId;
		this.description = description;
		this.date = date;
		this.issue = issue;
		this.operator = operator;
	}
	public Integer getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	@Override
	public String toString() {
		return "Solution [solutionId=" + solutionId + ", description=" + description + ", date=" + date + ", issue="
				+ issue + "]";
	}
	
	
}
