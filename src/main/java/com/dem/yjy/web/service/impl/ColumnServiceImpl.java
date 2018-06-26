package com.dem.yjy.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dem.yjy.web.dao.ColumnMapper;
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.model.ColumnExample;
import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.core.generic.GenericServiceImpl;
import com.dem.yjy.web.service.ColumnService;

@Service
public class ColumnServiceImpl extends GenericServiceImpl<Column, String> implements ColumnService {

	@Resource
	private ColumnMapper columnMapper;

	@Override
	public int insert(Column model) {
		return columnMapper.insertSelective(model);
	}

	@Override
	public int update(Column model) {
		return columnMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return columnMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Column selectById(String id) {
		return columnMapper.selectByPrimaryKey(id);
	}

	@Override
	public Column selectOne() {
		return null;
	}

	@Override
	public List<Column> selectList() {
		ColumnExample example = new ColumnExample();
		example.createCriteria().andIdIsNotNull();
		example.setOrderByClause("column_sort desc");
		return columnMapper.selectByExample(example);
	}

	@Override
	public GenericDao<Column, String> getDao() {
		return columnMapper;
	}

	@Override
	public List<Column> getListFront() {
		ColumnExample example = new ColumnExample();
		example.createCriteria().andColumnStatusEqualTo(1);
		example.setOrderByClause("column_sort desc");
		return columnMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int updateSort(String[] ids) throws Exception {
		int flag = 0;
		Column column = null;
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				column = new Column();
				column.setColumnSort(i + 1);
				column.setId(ids[i]);
				flag = columnMapper.updateSortByPrimaryKey(column);
				if (flag < 1) {
					throw new Exception("保存栏目排序出错");
				}
			}
			flag = ids.length;
		} else {
			flag = 0;
		}
		return flag;
	}

	@Override
	public long countAll() {
		ColumnExample example = new ColumnExample();
		example.createCriteria().andIdIsNotNull();
		return columnMapper.countByExample(example);
	}

}
