package com.gd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gd.model.Emp;

//DELETE FROM `gd_hibernate`.`emp99`;
//
//CREATE TABLE `gd_hibernate`.`emp99`(
//id int,
//name varchar(255),
//salary double,
//designation varchar(255)
//)
public class EmpDao {
	JdbcTemplate template;

	public EmpDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int id=1;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Emp p) {
		String sql = "insert into Emp99(id,name,salary,designation) values("
				+ (id++) + ",'" + p.getName() + "'," + p.getSalary() + ",'"
				+ p.getDesignation() + "')";
		return template.update(sql);
	}

	public int update(Emp p) {
		String sql = "update Emp99 set name='" + p.getName() + "', salary="
				+ p.getSalary() + ", designation='" + p.getDesignation()
				+ "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from Emp99 where id=" + id + "";
		return template.update(sql);
	}

	public Emp getEmpById(int id) {
		String sql = "select * from Emp99 where id=?";
		return template.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public List<Emp> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Emp>() {
			@Override
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

}
