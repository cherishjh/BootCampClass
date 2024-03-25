package com.encore.board.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

//ControllerAdvice와 exceptionhandler를 통해 예외처리의 공통화 로직 작성
@ControllerAdvice
@Slf4j
public class CommonException {
    @ExceptionHandler(EntityNotFoundException.class)            // controller에서 try, catch를 하고 있으면 안 잡힐 것
    public ResponseEntity<Map<String,Object>> entityNotFoundHandler(EntityNotFoundException e){
        log.error("Handler EntityNotFoundException message :"+ e.getMessage());
        return this.errResponseMessage(HttpStatus.NOT_FOUND,e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)            // controller에서 try, catch를 하고 있으면 안 잡힐 것
    public ResponseEntity<Map<String,Object>> IllegalArgueHandler(IllegalArgumentException e){
        log.error("Handler IllegalArgumentException message :"+ e.getMessage());
        return this.errResponseMessage(HttpStatus.BAD_REQUEST,e.getMessage());
    }

    private ResponseEntity<Map<String,Object>> errResponseMessage(HttpStatus status, String message){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("message", status.getReasonPhrase());
        body.put("error message", message);
        return new ResponseEntity<>(body,status);
    }

}
