package com.dem.yjy.web.service;

import java.util.Map;

import com.dem.yjy.core.generic.GenericService;
import com.dem.yjy.web.model.Preference;

/**
 * 角色 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午4:15:01
 **/
public interface PreferenceService extends GenericService<Preference, Integer> {
	/**
	 * 通过用户id 查询用户 拥有的角色
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, String> selectAllPreferences();

	int updateByName(Preference preference);
}
