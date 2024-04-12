package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 全局异常处理器，用于捕获并处理各种异常
// 根据不同的异常类型返回不同的响应内容和 HTTP 状态码。
// ControllerAdvice 标识这是一个全局异常处理器
@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理 ResourceNotFoundException 异常
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // 处理其他未知异常
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        // 记录异常日志
        // log.error("Uncaught exception: ", e);

        ErrorResponse errorResponse = new ErrorResponse(500, "An unexpected error occurred: " + e);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
