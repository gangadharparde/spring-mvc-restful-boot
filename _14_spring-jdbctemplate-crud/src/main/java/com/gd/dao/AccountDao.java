package com.gd.dao;

import java.util.List;

import com.gd.model.Account;

public interface AccountDao {

	public abstract int update(int accountNo, Account account);

	public abstract int remove(int accountNo);

	public abstract Account get(int accountNo);

	public abstract int save(Account account);

	public abstract List<Account> getlist();
}