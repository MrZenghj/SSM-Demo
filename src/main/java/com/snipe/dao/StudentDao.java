package com.snipe.dao;

import com.snipe.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  学生 Dao
 */
public interface StudentDao {
    //获取所有
    List<Student> getAll();
    //通过ID查询学生
    Student getById(Integer id);
    //通过名字查询学生
    List<Student> findByName(String sname);
    //添加学生
    void save(Student student);
    //更新学生
    void update(Student student);

}
