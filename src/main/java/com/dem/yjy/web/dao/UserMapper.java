package com.dem.yjy.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.dem.yjy.core.feature.orm.mybatis.Page;
import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.web.model.User;
import com.dem.yjy.web.model.UserExample;

/**
 * 用户Dao接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:49:57
 **/
public interface UserMapper extends GenericDao<User, Long> {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 用户登录验证查询
	 * 
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User record);

	/**
	 * 分页条件查询
	 * 
	 * @param page
	 * @param example
	 * @return
	 */
	List<User> selectByExampleAndPage(Page<User> page, UserExample example);
}