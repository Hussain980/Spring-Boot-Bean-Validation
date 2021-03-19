package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.FundTransfer;
import com.example.demo.Entity.User;

@Service
public interface UserService {

	public User createUser(User user);
	
	public User authenticateUser(String userName , String password);

	public void transferAmount(FundTransfer transfer);
}
