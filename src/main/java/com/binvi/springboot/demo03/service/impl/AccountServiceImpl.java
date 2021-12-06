package com.binvi.springboot.demo03.service.impl;

import com.binvi.springboot.demo03.entity.Account;
import com.binvi.springboot.demo03.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/9/1 23:28
 */
@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public void insertAccount(Account acc) {
		logger.info("insert account, account: {}", acc);
	}

	@Override
	public Account[] getAccounts(String name) {
		return new Account[0];
	}
}
