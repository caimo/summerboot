package com.summerboot.restservice.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    SYSTEM_ERROR_INVALID_INPUT("SUMMERBOOT.0000001", "input invalid, please check", HttpStatus.BAD_REQUEST),

    BUSINESS_ERROR_DATA_NOT_FOUND("SUMMERBOOT.0000101", "Data %s is not exist", HttpStatus.BAD_REQUEST),
    BUSINESS_ERROR_DATA_IS_EXIST("SUMMERBOOT.0000102", "Data %s is exist", HttpStatus.BAD_REQUEST),
    ;

    private final String errorCode;
    private final String errorDesc;
    private final HttpStatus httpCode;

    ExceptionEnum(String code, String desc, HttpStatus httpCode) {
        this.errorCode = code;
        this.errorDesc = desc;
        this.httpCode = httpCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }
}
