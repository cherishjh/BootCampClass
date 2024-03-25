package com.encore.board.Author.Controller;

import com.encore.board.Author.Service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
//Slf4j annotation(lombok)을 통해 쉽게 logback 로그 라이브러리 사용 가능
@Slf4j
public class TestController {
//  Slf4j annotation 사용하지 않고 직접 라이브러리 import 해서 logger 생성 가능
//    private static final Logger log= LoggerFactory.getLogger(LogTestController.class);

    @Autowired    // exceptionTestMethod 용
    private AuthorService authorService;


    @GetMapping("log/test2")
    public String testMethod1(){
        log.debug("디버그 로그입니다.");
        log.info("인포 로그입니다.");
        log.error("에러 로그입니다.");
        return "ok";
    }

    @GetMapping("exception/test2/{id}")
    public String exceptionTestMethod1(@PathVariable Long id){
        authorService.findById(id);
        return "ok";
    }

    @GetMapping("userinfo/test")
    public String userInfoTest(HttpServletRequest request){
//        로그인 유저 정보 얻는 방식
//        방법1: session에 atttribute 를 통해 접근
        String email1=request.getSession().getAttribute("email").toString();
        System.out.println("email1: "+email1);
//        방법2: session에서 Authentication 객체를 접근
        SecurityContext securityContext= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        String email2=securityContext.getAuthentication().getName();
        System.out.println("email2: "+ email2);
//        방법3: SecurityContextHolder에서 Authentication 객체 접근
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email3=authentication.getName();
        System.out.println("email3: "+ email3);
        return null;
    }


}
