package com.qworks.mrms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationModel {
	private int pageNumber;
	private int pageSize;
	private List<SortModel> sort;
}
