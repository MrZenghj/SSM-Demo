package com.snipe.dao;

import com.snipe.entity.SysPermission;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  系统权限Dao
 */
public interface SysPermissionDao {
    //获取所有权限
    List<SysPermission> getAllSysPermisson();
    //添加系统权限
    void save(SysPermission sysPermission);
    //修改系统权限
    void update(SysPermission sysPermission);
    //修改系统权限状态
    void updateStatus(@Param("id") String id, @Param("status") Integer status);
    //删除权限
    void delete(String id);

}
