package edu.hubu.myfun.exception;

public enum  CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找到问题不在了，要不要换个试试？"),

    ;

    private String message;
    private Integer code;

    CustomizeErrorCode( Integer code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
