package com.dem.yjy.web.service;

import java.util.List;
import com.dem.yjy.core.generic.GenericService;
import com.dem.yjy.web.model.Permission;

/**
 * 权限 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午12:02:39
 **/
public interface PermissionService extends GenericService<Permission, Integer> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Long roleId);

}
