package com.summerboot.restservice.exception;

public class ApiException extends RuntimeException {

    private Integer code;
    private ExceptionEnum exceptionEnum;

    public ApiException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getErrorDesc());
        this.code = exceptionEnum.getHttpCode().value();
        this.exceptionEnum = exceptionEnum;
    }

    public ApiException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}