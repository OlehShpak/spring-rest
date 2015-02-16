package com.shpak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.shpak.persistence.model.UserAccount;
import com.shpak.persistence.service.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	protected UserAccountService userAccountService;
	
	 @RequestMapping(value="/user/{idValue}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public UserAccount getUserAccountById(@PathVariable String idValue){
		 
		 UserAccount account = new UserAccount();
		 account = userAccountService.getUserAccountById(Long.parseLong(idValue));
		 
		 return account;
		 
	 }
	 
	 @RequestMapping(value="/getall", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<?> getAllUserAccounts(){
		 
		 List<UserAccount> list = new ArrayList<>();
		 list = userAccountService.getAllUserAccounts();
		 
		 return list;
		 
	 }
	 
	 
	 @RequestMapping( value="/user", method = RequestMethod.POST, headers = "Accept=application/json" )
	 @ResponseStatus(HttpStatus.CREATED)
	 public void addUserAccount(@RequestBody UserAccount userAccount){
		 
		 userAccountService.addUserAccount(userAccount);
		 
	 }
	
	 @RequestMapping(value="/user/{idValue}", method = RequestMethod.PUT, headers = "Accept=application/json")
	 @ResponseStatus(HttpStatus.OK)
	 public void updateUserAccount(@PathVariable String idValue, @RequestBody UserAccount userAccount ){
		 
		 userAccountService.updateUserAccountById(Long.parseLong(idValue), userAccount);
		 
	 }
	 
	 @RequestMapping(value="/user/{idValue}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 @ResponseStatus(HttpStatus.OK)
	 public void deleteUserAccountById(@PathVariable String idValue){
		 
		 userAccountService.deleteById(Long.parseLong(idValue));
		 
	 }
	 
	 
}
