package com.snipe.handle;

import com.snipe.DTO.Result;
import com.snipe.entity.Student;
import com.snipe.exception.ExcelException;
import com.snipe.exception.StudentException;
import com.snipe.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/**
 *  异常处理
 *      ----> 对捕获到的异常进行对应的处理
 */
@ControllerAdvice
public class HandleException {

    public HandleException(){
        System.out.println("进入HandleException");
    }

    //异常处理机制
    private final static Logger logger = LoggerFactory.getLogger(HandleException.class);

    //处理 Exception 抛出的StudentException异常
    @ExceptionHandler(StudentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result handleStudentException(NativeWebRequest request,StudentException s){
        logger.info("捕获到异常 StudentException ");
        //捕获自定义的异常
        /*if(e instanceof StudentException){
            StudentException s = (StudentException)e; //强转换
            return ResultUtil.error(s.getCode(),s.getMessage());
        }else {
            logger.error("【系统异常】:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }*/
        return ResultUtil.error(s.getCode(),s.getMessage());
    }

    //处理 Exception 抛出的StudentException异常
    @ExceptionHandler(ExcelException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result handleExcelException(NativeWebRequest request,ExcelException e){
        logger.info("捕获到异常 handleExcelException ");
        //捕获自定义的异常
        /*if(e instanceof StudentException){
            StudentException s = (StudentException)e; //强转换
            return ResultUtil.error(s.getCode(),s.getMessage());
        }else {
            logger.error("【系统异常】:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }*/
        return ResultUtil.error(e.getCode(),e.getMessages());
    }

}
