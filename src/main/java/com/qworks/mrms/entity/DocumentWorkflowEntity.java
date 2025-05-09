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
@Table(name = "document_workflow")
@Getter
@Setter
public class DocumentWorkflowEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "document")
	private DocumentEntity document;
	@Column(name = "current_state")
	private String currentState;
	@Column(name = "last_modified_date")
	@DateTimeFormat
	private Date lastModifiedDate;
	@ManyToOne
	@JoinColumn(name = "last_modified_by")
	private ApprovalEntity lastModifiedBy;
	@Column(name = "comments")
	private String comments;
}
