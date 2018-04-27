package com.dem.yjy.web.dao;

import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.model.ColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColumnMapper extends GenericDao<Column, String> {
	long countByExample(ColumnExample example);

	int deleteByExample(ColumnExample example);

	int deleteByPrimaryKey(String id);

	int insert(Column record);

	int insertSelective(Column record);

	List<Column> selectByExample(ColumnExample example);

	Column selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnExample example);

	int updateByExample(@Param("record") Column record, @Param("example") ColumnExample example);

	int updateByPrimaryKeySelective(Column record);

	int updateByPrimaryKey(Column record);
	
	int updateSortByPrimaryKey(Column record);
}