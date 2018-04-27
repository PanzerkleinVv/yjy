package com.dem.yjy.web.dao;

import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.web.model.Preference;
import com.dem.yjy.web.model.PreferenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreferenceMapper extends GenericDao<Preference, Integer> {
    long countByExample(PreferenceExample example);

    int deleteByExample(PreferenceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Preference record);

    int insertSelective(Preference record);

    List<Preference> selectByExample(PreferenceExample example);

    Preference selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Preference record, @Param("example") PreferenceExample example);

    int updateByExample(@Param("record") Preference record, @Param("example") PreferenceExample example);

    int updateByPrimaryKeySelective(Preference record);

    int updateByPrimaryKey(Preference record);
}