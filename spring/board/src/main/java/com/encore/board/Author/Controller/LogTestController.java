package com.encore.board.Author.Controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//Slf4j annotation(lombok)을 통해 쉽게 logback 로그 라이브러리 사용 가능
@Slf4j
public class LogTestController {
//  Slf4j annotation 사용하지 않고 직접 라이브러리 import 해서 logger 생성 가능
//    private static final Logger log= LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("log/test1")
    public String testMethod1(){
        log.debug("디버그 로그입니다.");
        log.info("인포 로그입니다.");
        log.error("에러 로그입니다.");
        return "ok";
    }







}
