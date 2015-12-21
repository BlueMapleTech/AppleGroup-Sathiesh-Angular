package com.example.angluar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.angluar.dto.User;

public interface SignupRepository extends JpaRepository<User, Long>,
		JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, Long> {

	@Query("select u from User as u where u.emailAddress=:emailAddress")
	public User performLogin(@Param("emailAddress") String emailAddress);
	

}
