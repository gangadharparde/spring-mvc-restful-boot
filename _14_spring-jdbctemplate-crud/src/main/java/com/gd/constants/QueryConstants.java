package com.gd.constants;

public class QueryConstants {
	public static final String INSERT_ACCOUNT = "INSERT INTO GD_ACCOUNT VALUES(?,?,?,?)";
	public static final String UPDATE_ACCOUNT = "UPDATE GD_ACCOUNT SET ACC_NO=?,ACC_NAME=?,ACC_TYPE=?,BAL=? WHERE  ACC_NO=?";
	public static final String DELETE_ACCOUNT = "DELETE FROM GD_ACCOUNT WHERE ACC_NO=?";
	public static final String SELECT_ACCOUNT = "SELECT * FROM GD_ACCOUNT WHERE ACC_NO=?";
	public static final String SELECT_ALL_ACCOUNT = "SELECT * FROM GD_ACCOUNT";

}