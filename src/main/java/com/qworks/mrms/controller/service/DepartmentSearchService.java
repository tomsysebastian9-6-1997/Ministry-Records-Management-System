package com.qworks.mrms.controller.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qworks.mrms.controller.service.helper.DepartmentSearchValidator;
import com.qworks.mrms.model.ReturnValue;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentSearchService {

	private DepartmentSearchValidator departmentSearchValidator;

	@Transactional
	public ResponseBody searchByDocumentDetails(String documentNumber, String title, String departmentCode,
			String documentType, String securityClassification, String workflowState, LocalDate createdFrom,
			LocalDate createdTo, String pendingApprovalByDepartment, int page, int size, String sort)
			throws ReturnValue {
		try {
			Map<String, Object> valid = departmentSearchValidator.validation(documentNumber, title, departmentCode,
					documentType, securityClassification, workflowState, createdFrom, createdTo,
					pendingApprovalByDepartment, page, size, sort);

			return null;

		} catch (ReturnValue rv) {
			throw rv;
		} catch (Exception e) {
			throw new ReturnValue(new Date(), 500, "Internal Server Error", "An unexpected error occurred",
					"/api/v1/documents/search");
		}
	}

}
