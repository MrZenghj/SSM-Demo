package com.snipe.service.impl;

import com.snipe.dao.StudentDao;
import com.snipe.entity.Student;
import com.snipe.enums.ResultEnum;
import com.snipe.exception.StudentException;
import com.snipe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentService")
public class StudentServiceImpl implements StudentService{
   @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> findByName(String sname) {
        return studentDao.findByName(sname);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    public void getAge(Integer id ) throws Exception {
        //获取学生
        Student s = studentDao.getById(id);
        Integer age = s.getAge();

        // 通过年龄判断身份
        if(age <= 12){
            throw new StudentException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 12 && age < 18 ){
            throw new StudentException(ResultEnum.MIDDLE_SCHOOL);
        }else{
            throw new StudentException(ResultEnum.HIGHT_SCHOOL);
        }


    }
}
