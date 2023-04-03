package com.abc.advice;

import com.abc.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

// 处理器通知切面（连接点为处理器方法）
@ControllerAdvice
public class ParamValidAdvice {

    @ExceptionHandler
    public ResponseEntity<String> validateHandle(StudentException ex) {
        String message = ex.getMessage();
        String fn = ex.getField();
        String fv = ex.getValue();
        String msg = fn + " : " + fv + " : " + message;
        return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> xxx(WebExchangeBindException ex) {
        return new ResponseEntity<String>(getExceptionMsg(ex), HttpStatus.BAD_REQUEST);
    }

    /**
     * 将异常对象转换为异常信息String
     * @param ex
     * @return
     */
    private String getExceptionMsg(WebExchangeBindException ex) {
        return ex.getFieldErrors() // 集合，元素是出现异常的属性异常信息
                .stream()  // 转换为stream流，元素为出现异常的属性异常信息
                .map(e -> e.getField() + " : " + e.getDefaultMessage()) // 将stream中的异常类型元素映射为String类型元素
                .reduce("", (s1, s2) -> s1 + "\n" + s2); // 将Stream中的String元素凭借为一个String
    }

}
