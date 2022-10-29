package mao.use.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Set;

/**
 * Project name(项目名称)：hibernate_validator_demo
 * Package(包名): mao.hibernate_validator_demo.controller
 * Class(类名): ExceptionConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/29
 * Time(创建时间)： 13:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@RestControllerAdvice
public class ExceptionConfiguration
{

    private static final Logger log = LoggerFactory.getLogger(ExceptionConfiguration.class);

    @ExceptionHandler({ConstraintViolationException.class, BindException.class})
    public String validateException(Exception ex, HttpServletRequest request)
    {
        log.error("异常：", ex);
        String msg = null;
        if (ex instanceof ConstraintViolationException)
        {
            ConstraintViolationException constraintViolationException =
                    (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations =
                    constraintViolationException.getConstraintViolations();
            ConstraintViolation<?> next = violations.iterator().next();
            msg = next.getMessage();
        }
        else if (ex instanceof BindException)
        {
            BindException bindException = (BindException) ex;
            msg = Objects.requireNonNull(bindException.getBindingResult().getFieldError()).getDefaultMessage();
        }
        return msg;
    }
}
