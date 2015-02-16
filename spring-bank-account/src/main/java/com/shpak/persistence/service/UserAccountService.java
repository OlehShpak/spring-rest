package com.shpak.persistence.service;

import java.util.List;

import com.shpak.persistence.model.UserAccount;



public interface UserAccountService {
	
	void addUserAccount(UserAccount userAccount);
	
	void deleteById(Long id);
	
	List<UserAccount> getAllUserAccounts();
	
	UserAccount getUserAccountById(Long id);
	
	void updateUserAccountById(Long id, UserAccount userAccount);
	
}
