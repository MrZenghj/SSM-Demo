package com.snipe.controller;

import com.snipe.DTO.Result;
import com.snipe.entity.Student;
import com.snipe.service.StudentService;
import com.snipe.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    /**
     *  查询所有学生
    */
    @ResponseBody
    @RequestMapping(value = "/Student",method = RequestMethod.GET)
    public List<Student> getAll(){
        return studentService.getAll();
    }

    /**
     *  通过id查询学生
     *  @param id  主键id
     */
    @ResponseBody
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Student findById(@RequestParam("id")Integer id){
        return studentService.getById(id);
    }

    /**
     *  通过name查询学生
     *  @param sname  学生名
     */
    @ResponseBody
    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public List<Student> findByName(@RequestParam("sname")String sname){
        return  studentService.findByName(sname);
    }

    /**
     *  保存学生
     *  @param student 学生实体类
     */
    @ResponseBody
    @RequestMapping(value = "/Student",method = RequestMethod.POST)
    public void save(Student student){
        System.out.println(student);
        studentService.save(student);
    }
    /**
    *   更新学生
    *   @param student 学生实体
    */
    @ResponseBody
    @RequestMapping(value = "/Student",method = RequestMethod.PUT)
    public void update(Student student){
       studentService.update(student);
    }

    /**
     *   异常处理
     *
     */
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.GET)
    public Result exception(@PathVariable("id")Integer id) throws Exception {
        studentService.getAge(id);
        return new Result();
    }

    @ResponseBody
    @RequestMapping(value = "/findBy",method = RequestMethod.GET)
    public Result findBy(@RequestParam("id")Integer id){
        Student s = studentService.getById(id);
        return  ResultUtil.success(s);
    }
}
