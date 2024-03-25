package com.encore.classProject_ordering.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerClass {
    @ExceptionHandler(EntityNotFoundException.class)            // controller에서 try, catch를 하고 있으면 안 잡힐 것
    public ResponseEntity<Map<String,Object>> entityNotFoundHandler(EntityNotFoundException e){
        log.error("Handler EntityNotFoundException message :"+ e.getMessage());
        return ErrorResponseDto.makeMessage(HttpStatus.NOT_FOUND,e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)            // controller에서 try, catch를 하고 있으면 안 잡힐 것
    public ResponseEntity<Map<String,Object>> IllegalArgueHandler(IllegalArgumentException e){
        log.error("Handler IllegalArgumentException message :"+ e.getMessage());
        return ErrorResponseDto.makeMessage(HttpStatus.BAD_REQUEST,e.getMessage());
    }

    public static ResponseEntity<Map<String,Object>> errResponseMessage(HttpStatus status, String message){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("message", status.getReasonPhrase());
        body.put("error message", message);
        return new ResponseEntity<>(body,status);
    }

}
