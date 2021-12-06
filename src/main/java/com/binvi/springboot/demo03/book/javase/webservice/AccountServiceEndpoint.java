package com.binvi.springboot.demo03.book.javase.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.binvi.springboot.demo03.entity.Account;
import com.binvi.springboot.demo03.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/9/1 23:25
 */
@WebService(serviceName="AccountService")
public class AccountServiceEndpoint extends SpringBeanAutowiringSupport {

	@Autowired
	private AccountService biz;

	@WebMethod
	public void insertAccount(Account acc) {
		biz.insertAccount(acc);
	}

	@WebMethod
	public Account[] getAccounts(String name) {
		return biz.getAccounts(name);
	}
}
