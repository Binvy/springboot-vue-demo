package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.Account;

public interface AccountService {

	void insertAccount(Account acc);

	Account[] getAccounts(String name);
}
