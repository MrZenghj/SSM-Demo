package com.snipe.exception;

import com.snipe.enums.ResultEnum;

/**
 *  @Description 自定义Excel文件上传出现的异常
 */
public class ExcelException extends RuntimeException {

    //错误代码
    private Integer code;
    private String messages;
    public ExcelException(Integer code,String messages){
        super(messages); //通过父类传递信息
        this.code = code; //获取错误代码
        this.messages = messages;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
