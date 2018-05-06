package com.snipe.exception;

import com.snipe.enums.ResultEnum;

/**
 *  @Description 自定义Student出现的异常
 */
public class StudentException extends RuntimeException {
    //错误代码
    private Integer code;
    public StudentException(ResultEnum e){
        super(e.getMessage()); //通过父类传递信息
        this.code = e.getCode(); //获取错误代码
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
