package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.gd.constants.QueryConstants;
import com.gd.model.Account;

public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate;

	public AccountDaoImpl() {
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Account account) {
		// "INSERT INTO gd_account VALUES(?,?,?,?)";
		int insertedRows = jdbcTemplate.update(QueryConstants.INSERT_ACCOUNT, account.getAccountNo(),
				account.getAccountName(), account.getAccountType(), account.getBalance());
		return insertedRows;
	}

	@Override
	public int update(int accountNo, Account account) {
		// "UPDATE GD_ACCOUNT SET ACC_NO=?,ACC_NAME=?,ACC_TYPE=?,BAL=? WHERE
		// ACC_NO=?";
		int updatedRows = jdbcTemplate.update(QueryConstants.UPDATE_ACCOUNT, new Object[] { account.getAccountNo(),
				account.getAccountName(), account.getAccountType(), account.getBalance(), accountNo });
		return updatedRows;
	}

	@Override
	public int remove(int accountNo) {
		// "DELETE FROM GD_ACCOUNT WHERE ACC_NO=?";
		int deletedRows = jdbcTemplate.update(QueryConstants.DELETE_ACCOUNT, new Object[] { accountNo });
		return deletedRows;
	}

	@Override
	public Account get(int accountNo) {
		final Account account = new Account();
		return (Account) jdbcTemplate.query(QueryConstants.SELECT_ACCOUNT,
				new ResultSetExtractor<Account>() {
						public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							account.setAccountNo(rs.getInt(1));
							account.setAccountName(rs.getString(2));
							account.setAccountType(rs.getString(3));
							account.setBalance(rs.getDouble(4));
						}
						return account;
					}
				}
				,new Object[] { accountNo });
	}

	@Override
	public List<Account> getlist() {
		List<Account> listAccounts = jdbcTemplate.query(QueryConstants.SELECT_ALL_ACCOUNT, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setAccountNo(rs.getInt(1));
				account.setAccountName(rs.getString(2));
				account.setAccountType(rs.getString(3));
				account.setBalance(rs.getDouble(4));
				return account;
			}

		});
		return listAccounts;
	}
}
