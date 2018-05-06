package com.snipe.dao;

import com.snipe.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  系统角色dao
 * */
public interface SysRoleDao {
    //查找所有角色
    List<SysRole> getAllSysRole();
    //添加系统角色
    void save(SysRole sysRole);
    //修改系统角色
    void update(SysRole sysRole);
    //删除角色
    void delete(String id);

}
