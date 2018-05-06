package com.snipe.controller;

import com.snipe.entity.User;
import com.snipe.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/Users",method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/findByAccountAndPassword",method = RequestMethod.GET)
    public User findByAccountAndPassword(@RequestParam("account")String account,
                                         @RequestParam("password")String password){
        return userService.getByAccountAndPassword(account,password);
    }

    @RequestMapping(value = "/Users",method = RequestMethod.POST)
    public void save(User user){
        System.out.println(user);
        userService.save(user);
    }

    @RequestMapping(value = "/Users",method = RequestMethod.PUT)
    public void update(User user){
        System.out.println(user);
        userService.update(user);
    }

    @RequestMapping(value = "/deleteByStatus",method = RequestMethod.GET)
    public void deleteByStatus(@RequestParam("id")Integer id,
                               @RequestParam("status")String status){
        System.out.println("id:"+ id + ", "+ "status:" + status);
       userService.deleteByStatus(id,status);
    }

    @RequestMapping(value = "/Users",method = RequestMethod.DELETE)
    public void delete(@RequestParam("id")Integer id){
        System.out.println("id:"+ id);
        userService.delete(id);
    }

}
