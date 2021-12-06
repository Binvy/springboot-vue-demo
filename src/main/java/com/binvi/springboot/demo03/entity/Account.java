package com.binvi.springboot.demo03.entity;

import java.math.BigDecimal;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/9/1 23:27
 */
public class Account {

	private String id;

	private String name;

	private BigDecimal account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAccount() {
		return account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Account)) return false;

		Account account1 = (Account) o;

		if (getId() != null ? !getId().equals(account1.getId()) : account1.getId() != null) return false;
		if (getName() != null ? !getName().equals(account1.getName()) : account1.getName() != null) return false;
		return getAccount() != null ? getAccount().equals(account1.getAccount()) : account1.getAccount() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getAccount() != null ? getAccount().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", account=" + account +
				'}';
	}
}
