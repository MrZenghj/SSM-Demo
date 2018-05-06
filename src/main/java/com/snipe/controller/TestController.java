package com.snipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@Controller
@RequestMapping
public class TestController {
    @RequestMapping("/Test")
    public void testRadio(HttpServletRequest request){
       String[] hobbits =  request.getParameterValues("hobbit");
       for ( String hobbit: hobbits) {
            System.out.println(hobbit);
       }
       String sex = request.getParameter("sex");
       System.out.println(sex);
    }

    @RequestMapping(value = "/carInfo")
    @ResponseBody
    public void testUp(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("hello");
        System.out.println(file);
        PrintWriter pw = response.getWriter();
        pw.write("success");
    }
}
