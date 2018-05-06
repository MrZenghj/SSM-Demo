package com.snipe.dao;

import com.snipe.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;
/**
 *  系统用户dao
 * */
public interface SysUserDao {
    //查找所有用户
    List<SysUser> getAllSysUser();
    //添加系统用户
    void save(SysUser sysUser);
    //修改系统用户
    void update(SysUser sysUser);
    //修改系统用户状态
    void updateStatus(@Param("id") String id, @Param("status") Integer status);
    //删除用户
    void delete(String id);
    //验证用户通过用户名和密码
    SysUser getByNameAndPassword(@Param("name") String name,@Param("password") String password);
    //批量插入用户
    void updateBatch(List<SysUser> list);
}
