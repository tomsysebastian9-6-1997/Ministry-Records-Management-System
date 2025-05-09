package com.qworks.mrms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "document")
@Getter
@Setter
public class DocumentEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "document_number")
	private String documentNumber;
	@Column(name = "title")
	private String title;
	@Column(name = "discription")
	private String discription;
	@Column(name = "creation_date")
	@DateTimeFormat
	private Date creationDate;
	@ManyToOne
	@JoinColumn(name = "owner_department")
	private DepartmentEntity ownerDepartment;
	@Column(name = "document_type")
	private String documentType;
	@Column(name = "security_classification")
	private String securityClassification;
	@Column(name = "digital_file_location")
	private String digitalFileLocation;
	@Column(name = "version")
	private String version;
}
