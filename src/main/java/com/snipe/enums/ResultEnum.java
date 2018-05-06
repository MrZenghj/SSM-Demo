package com.snipe.enums;

/**
 *  自定义枚举类 存储消息码和错误信息
 */
public enum ResultEnum {
    //自定义一些错误
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"少年人，你还小"),
    MIDDLE_SCHOOL(101,"青年人，不错"),
    HIGHT_SCHOOL(102,"恭喜你独立了")
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
