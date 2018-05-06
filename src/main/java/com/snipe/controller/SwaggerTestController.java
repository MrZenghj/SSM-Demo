package com.snipe.controller;

import com.snipe.entity.User;
import com.snipe.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/swaggerTest")
@Api(value="/swaggerTest",description="测试接口描述")
public class SwaggerTestController {

    @Autowired
    private UserService userService;

    //方法注释：
    @ResponseBody
    @RequestMapping(value = "/getUserById")
    @ApiOperation(value = "根据ID获取户信息", httpMethod = "GET", notes = "get user by id",response = User.class)
    public User getUserById(@ApiParam(required=true,value="用户ID",name="userId")@RequestParam(value="userId")Integer userId) {
        User user = userService.getById(userId);
        System.out.println(user);
        return user;
    }

}
