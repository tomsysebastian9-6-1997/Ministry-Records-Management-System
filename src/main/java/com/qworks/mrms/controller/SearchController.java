package com.qworks.mrms.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qworks.mrms.controller.service.DepartmentSearchService;
import com.qworks.mrms.model.DocumentResponseDto;
import com.qworks.mrms.model.ReturnValue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
public class SearchController {

	private DepartmentSearchService departmentSearchService;

	@GetMapping(value = "/api/v1/documents/search")
	private ResponseBody searchByDocumentDetails(@RequestParam("documentNumber") String documentNumber,
			@RequestParam("title") String title, @RequestParam("departmentCode") String departmentCode,
			@RequestParam("documentType") String documentType,
			@RequestParam("securityClassification") String securityClassification,
			@RequestParam("workflowState") String workflowState, @RequestParam("createdFrom") LocalDate createdFrom,
			@RequestParam("createdTo") LocalDate createdTo,
			@RequestParam("pendingApprovalByDepartment") String pendingApprovalByDepartment,
			@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sort") String sort) {

		try {
			ResponseBody documentResponseModel = departmentSearchService.searchByDocumentDetails(documentNumber, title,
					departmentCode, documentType, securityClassification, workflowState, createdFrom, createdTo,
					pendingApprovalByDepartment, page, size, sort);

			return documentResponseModel;
		} catch (ReturnValue rv) {
			return (ResponseBody) rv;
		}
	}
}
