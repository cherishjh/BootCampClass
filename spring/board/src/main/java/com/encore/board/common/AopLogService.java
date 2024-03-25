package com.encore.board.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class AopLogService {

//   aop의 대상이 되는 controller, service 등을 정리하는 annotation
//    @Pointcut("excution(* com.encore.board..controller..*.*(..)")     //board 밑에 있는 모든 controller 패키지에 대해서 실행 --> 점 2개
                                                                        // 패키지 명이라서 controller 의 c가 소문자
    @Pointcut("within(@org.springframework.stereotype.Controller *)")    // Controller annotation ; annotation이라 Controller 의 c가 대문자
    public void controllerPointCut(){
    }


//  방식 1: before, after 사용
//   before: 메서드가 실행되기 전에 인증, 입력값 검증 등 수행하는 용도로 사용하는 사전 단계
/*    @Before("controllerPointCut()")
//    @Order(1) : 순서 정의
    public void beforeController(JoinPoint joinPoint){
        log.info("Before Controller");
        ServletRequestAttributes servletRequestAttributes=
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req= servletRequestAttributes.getRequest();

//        json 형태로 사용자의 요청을 조립하기 위한 로직
        ObjectMapper objectMapper= new ObjectMapper();
        ObjectNode objectNode= objectMapper.createObjectNode();
        objectNode.put("Method Name",joinPoint.getSignature().getName());
        objectNode.put("CRUD Name",req.getMethod());
        Map<String, String[]> paramMap = req.getParameterMap();
        ObjectNode objectNodeDetail= objectMapper.valueToTree(paramMap);
        objectNode.set("user inputs", objectNodeDetail);
        log.info("user request info"+objectNode);
    }

    @After("controllerPointCut()")
    public void afterController(){
        log.info("end controller");
    }*/


//    방식 2: Around 사용  : 가장 빈번히 사용
    @Around("controllerPointCut()")
//    join point 란 aop 대상으로 하는 컨트롤러의 특정 메서드 의미
    public Object controllerLogger(ProceedingJoinPoint proceedingJoinPoint){
//        log.info("request method" + proceedingJoinPoint.getSignature().toString());

//        사용자의 요청값을 json 형태로 출력하기 위해 httpServletRequest 객체를 꺼내는 로직
        ServletRequestAttributes servletRequestAttributes=
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req= servletRequestAttributes.getRequest();

//        json 형태로 사용자의 요청을 조립하기 위한 로직
        ObjectMapper objectMapper= new ObjectMapper();
        ObjectNode objectNode= objectMapper.createObjectNode();
        objectNode.put("Method Name",proceedingJoinPoint.getSignature().getName());
        objectNode.put("CRUD Name",req.getMethod());
        Map<String, String[]> paramMap = req.getParameterMap();
        ObjectNode objectNodeDetail= objectMapper.valueToTree(paramMap);
        objectNode.set("user inputs", objectNodeDetail);
        log.info("user request info"+objectNode);

        try {
            //본래의 컨트롤러의 메서드를 호출하는 부분
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
