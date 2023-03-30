package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Issue;


@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
	
}
