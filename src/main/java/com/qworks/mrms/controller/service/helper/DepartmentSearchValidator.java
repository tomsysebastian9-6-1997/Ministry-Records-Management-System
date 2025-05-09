package com.qworks.mrms.controller.service.helper;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.qworks.mrms.constants.MrmsConstants;
import com.qworks.mrms.model.ErrorDetailsModel;
import com.qworks.mrms.model.ReturnValue;

@Component
public class DepartmentSearchValidator {

	public Map<String, Object> validation(String documentNumber, String title, String departmentCode,
			String documentType, String securityClassification, String workflowState, LocalDate createdFrom,
			LocalDate createdTo, String pendingApprovalByDepartment, int page, int size, String sort) throws Exception, ReturnValue {
//		Map<String, Object> response = new HashMap<>();
		Map<String, Object> validParams = new HashMap<>();
//		Map<String, String> invalidParams = new HashMap<>();
		Date timestamp = new Date();

		if (documentNumber != null || documentNumber != "")
			validParams.put("documentNumber",
					MrmsConstants.SEARCH_KEYNAME.concat(documentNumber).concat(MrmsConstants.SEARCH_KEYNAME));
		if (title != null || title != "")
			validParams.put("title", MrmsConstants.SEARCH_KEYNAME.concat(title).concat(MrmsConstants.SEARCH_KEYNAME));
		if (departmentCode != null || departmentCode != "")
			validParams.put("departmentCode", departmentCode);
		if (documentType != null || documentType != "") {
			try {
				validDocumentType(documentType);

				validParams.put("documentType", documentType);
			} catch (Exception e) {
				ErrorDetailsModel edm = new ErrorDetailsModel("documentType", e.getMessage());
				throw new ReturnValue(timestamp, 400, "Bad Request", "Invalid parameter value", edm, "/api/v1/documents/search");
			}
		}
		if (securityClassification != null || securityClassification != "") {
			try {
				validSecurityClassification(securityClassification);

				validParams.put("securityClassification", securityClassification);
			} catch (Exception e) {
				ErrorDetailsModel edm = new ErrorDetailsModel("securityClassification", e.getMessage());
				throw new ReturnValue(timestamp, 400, "Bad Request", "Invalid parameter value", edm, "/api/v1/documents/search");
			}
		}
		if (workflowState != null || workflowState != "") {
			try {
				validWorkflowState(workflowState);

				validParams.put("workflowState", workflowState);
			} catch (Exception e) {
				ErrorDetailsModel edm = new ErrorDetailsModel("workflowState", e.getMessage());
				throw new ReturnValue(timestamp, 400, "Bad Request", "Invalid parameter value", edm, "/api/v1/documents/search");
			}
		}
		if(createdFrom != null)
			validParams.put("createdDate", createdFrom);
		if(createdTo != null)
			validParams.put("createdDate", createdTo);
		if(pendingApprovalByDepartment != null)
			validParams.put("approvalStatus", "PENDING");
		if(page >= 0)
			validParams.put("page", page);
		if(size >= 0)
			validParams.put("size", size);
		if(sort != null) {
			String[] sortArray = sort.split("~");
			validParams.put("sortField", sortArray[0]);
			validParams.put("sortDirection", sortArray[1]);
		}
//		response.put(key, validParams);

		return validParams;
	}

	private boolean validWorkflowState(String workflowState) throws Exception {
		switch (workflowState) {
		case "DRAFT":
			return true;
		case "REVIEW":
			return true;
		case "APPROVED":
			return true;
		case "PUBLISHED":
			return true;
		case "ARCHIVED":
			return true;
		default:
			throw new Exception("Must be one of [DRAFT, REVIEW, APPROVED, PUBLISHED, ARCHIVED]");
		}
		
	}

	private boolean validSecurityClassification(String securityClassification) throws Exception {
		switch (securityClassification) {
		case "PUBLIC":
			return true;
		case "INTERNAL":
			return true;
		case "CONFIDENTIAL":
			return true;
		case "RESTRICTED":
			return true;
		default:
			throw new Exception("Must be one of [PUBLIC, INTERNAL, CONFIDENTIAL, RESTRICTED]");
		}
		
	}

	private boolean validDocumentType(String documentType) throws Exception {
		switch (documentType) {
		case "MEMO":
			return true;
		case "LETTER":
			return true;
		case "REPORT":
			return true;
		case "POLICY":
			return true;
		case "ORDER":
			return true;
		default:
			throw new Exception("Must be one of [MEMO, LETTER, REPORT, POLICY, ORDER]");
		}
	}

}
