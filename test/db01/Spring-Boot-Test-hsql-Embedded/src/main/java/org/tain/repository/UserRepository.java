package org.tain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tain.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	// find user by email
	User findByEmail(String email);
	
	// find users by firstName
	List<User> findByNameFirstName(String firstName);
	
	// find users by lastName
	List<User> findByNameLastName(String lastName);
	
	// find users by country
	List<User> findByAddressCountry(String country);
}
