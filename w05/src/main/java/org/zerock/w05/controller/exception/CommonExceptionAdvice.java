package org.zerock.w05.controller.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException){
        log.info("error...exceptNumber");
        log.info(numberFormatException);
        return "NUMBER FORMAT EXCEPTION";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception){
        log.info("error...exceptCommon");
        log.info(exception);

        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + exception.getMessage()+"</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });

        buffer.append("</ul");

        return buffer.toString();
    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound(){
        return "custom404";
    }
}
