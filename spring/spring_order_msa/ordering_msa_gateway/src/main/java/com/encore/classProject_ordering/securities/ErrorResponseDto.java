package com.encore.classProject_ordering.securities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseDto {
    public static ResponseEntity<Map<String,Object>> makeMessage(HttpStatus status, String message){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("status_message", status.getReasonPhrase());
        body.put("error_message", message);
        return new ResponseEntity<>(body,status);
    }
}
