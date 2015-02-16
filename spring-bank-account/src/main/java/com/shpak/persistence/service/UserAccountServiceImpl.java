package com.shpak.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shpak.persistence.model.UserAccount;
import com.shpak.persistence.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public void addUserAccount(UserAccount userAccount) {
		userAccountRepository.saveAndFlush(userAccount);
		
	}

	@Override
	public void deleteById(Long id) {
		userAccountRepository.delete(id);
		
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		List<UserAccount> list = new ArrayList<UserAccount>();
		list = userAccountRepository.findAll();
		return list;
	}

	@Override
	public UserAccount getUserAccountById(Long id) {
		UserAccount userAccount = userAccountRepository.findOne(id);
		return userAccount;
	}

	@Override
	public void updateUserAccountById(Long id, UserAccount userAccount) {
		userAccount.setId(id);
		userAccountRepository.updateUserAccountById(userAccount.getId(), userAccount.getFullname(), userAccount.getDescription(),
				userAccount.getCreatedDate(), userAccount.getBalance(), userAccount.getActive());
		
	}

}
