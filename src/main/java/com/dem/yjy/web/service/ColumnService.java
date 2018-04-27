package com.dem.yjy.web.service;

import com.dem.yjy.web.model.Column;

import java.util.List;

import com.dem.yjy.core.generic.GenericService;

public interface ColumnService extends GenericService<Column, String> {

	public List<Column> getListFront();

	public int updateSort(String[] ids) throws Exception;
	
	public long countAll();
}
