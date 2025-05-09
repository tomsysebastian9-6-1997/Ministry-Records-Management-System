package com.qworks.mrms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "approval")
@Getter
@Setter
public class ApprovalEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	@JoinColumn(name = "document_workflow")
	private List<DocumentWorkflowEntity> documentWorkflow;
	@ManyToOne
	@JoinColumn(name = "approver_department")
	private DepartmentEntity approverDepartment;	
	@Column(name = "approval_status", length = 10)
	private String approvalStatus;
	@Column(name = "approval_date")
	@DateTimeFormat
	private Date approvalDate;
	@Column(name = "approval_id")
	private String approvalId;
	@Column(name = "comments")
	private String comments;
}
