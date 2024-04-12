package com.test.exception;

// 自定义异常类，更好地区分不同类型的异常,便于异常处理
// 资源未找到异常
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String message) {
        super(404, message);
    }
}
