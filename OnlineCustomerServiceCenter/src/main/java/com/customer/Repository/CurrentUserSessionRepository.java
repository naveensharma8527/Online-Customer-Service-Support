package com.customer.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {
	
	public CurrentUserSession findByUuid (String uuid);

	

	

}
