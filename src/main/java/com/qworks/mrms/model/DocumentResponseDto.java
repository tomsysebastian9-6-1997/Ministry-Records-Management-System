package com.qworks.mrms.model;

import java.util.List;

import com.qworks.mrms.entity.DocumentWorkflowEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentResponseDto {
	private List<DocumentWorkflowEntity> content;
	private PaginationModel paginapageable;
	private int totalElements;
	private int totalPages;
	private boolean last;
	private boolean first;
	private int size;
	private int number;
	private int numberOfElements;
	private boolean empty;
}
