package com.qworks.mrms.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentRequestModel {
	private String documentNumber;
	private String title;
	private String departmentCode;
	private String documentType;
	private String securityClassification;
	private String workflowState;
	private LocalDate createdFrom;
	private LocalDate createdTo;
	private String pendingApprovalByDepartment;
	private int page;
	private int size;
	private List<SortModel> sort;
	
}
