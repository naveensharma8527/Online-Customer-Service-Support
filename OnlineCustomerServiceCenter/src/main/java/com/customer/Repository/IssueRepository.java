package com.customer.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Integer> {
	


}
