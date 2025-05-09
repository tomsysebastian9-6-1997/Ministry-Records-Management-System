package com.qworks.mrms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter
@Setter
public class DepartmentEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	@Column(name = "department_code")
	private String departmentCode;
	@Column(name = "department_name")
	private String departmentName;
	@Column(name = "discription")
	private String discription;
	@Column(name = "active_status")
	private int activeStatus;
	
}
