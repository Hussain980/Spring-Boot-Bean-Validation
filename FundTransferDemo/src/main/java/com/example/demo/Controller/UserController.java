package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.FundTransfer;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
@Api(value = "UserController")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "user registeration")
	@PostMapping("/register")
	public Map<String, Object> createUser(@Validated @RequestBody User user) {
		log.info("logger info  {} "+ user);
		User users =  userService.createUser(user);
		Map<String, Object> userMap = new HashMap();
		userMap.put("userId", users.getUserId());
		userMap.put("password", users.getPassword());
		return userMap;
	}
	
	
	@ApiOperation(value = "user login")
	@PostMapping("/login")
	public Map<String, Object> authenticateUser(@RequestBody User user) {
		log.info("inside authenticate user {} "+user);
		User users =  userService.authenticateUser(user.getUserId(),user.getPassword());
		Map<String, Object> userMap = new HashMap();
		userMap.put("accNumber", users.getAccNumber());
		userMap.put("accbalance", users.getAccBalance());
		return userMap;
	}
	
	
	@ApiOperation(value = "user Transaction")
	@PostMapping("/transfer")
	public String TransactionFund(@RequestBody FundTransfer transfer) {
		log.info("inside transactionFund "+transfer);
		userService.transferAmount(transfer);
		return "transaction completed";
	}
	
	
	
}
