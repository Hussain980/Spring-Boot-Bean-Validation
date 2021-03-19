package com.example.demo.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.FundTransfer;
import com.example.demo.Entity.User;
import com.example.demo.Exception.AccountExist;
import com.example.demo.Exception.InsufficientFund;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public User createUser(User user) {
		log.info("inside create user {} "+ user);
		User userExist = userRepo.findByAadharIdOrUserId(user.getAadharId(), user.getUserId());
		if(userExist != null) {
			throw new AccountExist("Account already exist with same credentials");
		    
		}
		
		if(userExist == null) {
			User userdb = userRepo.findByAccNumber(user.getAccNumber());
			if(userdb != null) {
				throw new AccountExist("Account already exist with same Account Number");
				
			}

		}
		
		return userRepo.save(user);
		
	}

	@Override
	public User authenticateUser(String userId, String password) {
		log.info("inside authenticateUser {} "+ userId + " "+password );
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if (user == null) {
			throw new com.example.demo.Exception.UserNotFoundException("Invalid Credentials");
		}
		return user;
	}

	@Override
	public void transferAmount(FundTransfer transfer) {
 
		 log.info("inside transferAmount {} "+ transfer);
		 
		User user1 = userRepo.findByAccNumber(transfer.getFromAcc());
		User user2 = userRepo.findByAccNumber(transfer.getToAcc());
		if(user1 == null || user2 == null) {
			throw new UserNotFoundException("User Not Found");
		}
		if(transfer.getAmount()>user1.getAccBalance())  {
			throw new InsufficientFund("Insufficient Fund for transfer");
		}
		
		else if(transfer.getAmount() == 0) {
			throw new InsufficientFund("transfer amount should be greater than zero");
		}
		double d = user1.getAccBalance();
		double d1 = user2.getAccBalance();
		double amount = transfer.getAmount();
		double sub = d-amount;
		double add = d1+amount;
		user1.setAccBalance(sub);
		userRepo.save(user1);
		user2.setAccBalance(add);
		userRepo.save(user2);

	}

}
