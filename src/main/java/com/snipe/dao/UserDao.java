package com.snipe.dao;

import com.snipe.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  用户 Dao
 */
public interface UserDao {
    //获取所有用户
    List<User> getAll();
    //通过ID查询用户
    User getById(Integer id);
    //通过账户和密码验证用户
    User getByAccountAndPassword(@Param("account")String account,@Param("password")String password);
    //添加用户
    void save(User user);
    //更新用户
    void update(User user);
    //逻辑删除用户
    void deleteByStatus(@Param("id")Integer id,@Param("status")String status);
    //删除用户
    void delete(Integer id);
}
