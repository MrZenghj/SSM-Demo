package com.snipe.DTO;

/**
 *  输出信息实体
 *  @description 用户输出消息码和消息
 * @param <T>
 */
public class Result<T> {
    private Integer code; //信息码
    private String message; //消息
    private T date;

    public Result() {}

    public Result(Integer code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
