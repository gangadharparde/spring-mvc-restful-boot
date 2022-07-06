package com.gd.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private Integer age;
	private String ipAddress;
	public Date createdDate;
	public Date lastModifiedDate;

}

