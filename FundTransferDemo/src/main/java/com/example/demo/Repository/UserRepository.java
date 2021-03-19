package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUserIdAndPassword(String userId, String password);
	
	
	public User findByAccNumber(Long accNumber);


	public User findByAadharIdOrUserId(String aadharId, String userId);




}
