package com.encore.basic.Controller;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberRequestDto;
import com.encore.basic.domain.MemberResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("response/entity")
public class ResponseEntityController {
//    @Response Status annotation 방식
    @GetMapping("responsestatus")
    @ResponseStatus(HttpStatus.CREATED)
    public String reponseStatus(){
        return "ok";
    }

    @GetMapping("responsestatus2")
    @ResponseStatus(HttpStatus.CREATED)
    public Member responseStatus2(){
        Member member= new Member("avs","abs", "abc");
        return member;
    }

    @GetMapping("custom1")
    public ResponseEntity<Member> custom1(){
        Member member= new Member("avs","abs", "abc");
        return new ResponseEntity<>(member,HttpStatus.CREATED);
    }

//    ResponseEntity<String>일 경우 text/html로 설정
    @GetMapping("custom2")
    public ResponseEntity<String> custom2(){
        String html= "<h1>없는 id 입니다.</h1>";
        return new ResponseEntity<>(html,HttpStatus.NOT_FOUND);
    }

    //map 형태의 메세지 커스텀
   /* @GetMapping("map_custom1")
    public static ResponseEntity<Map<String,String>> customMap1(){
        Map<String, String> body= new HashMap<>();
        HttpStatus status= HttpStatus.INTERNAL_SERVER_ERROR;
        body.put("status",Integer.toString(status.value()));
        body.put("error message", status.getReasonPhrase());
        return new ResponseEntity<>(body,status);
    }*/

    //공통화
  /*  public static ResponseEntity<Map<String,Object>> errResponseMessage(HttpStatus status){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("error message", status.getReasonPhrase());
        return new ResponseEntity<>(body,status);
    }
*/
      public static ResponseEntity<Map<String,Object>> errResponseMessage(HttpStatus status, String message){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("message", status.getReasonPhrase());
        body.put("error message", message);
        return new ResponseEntity<>(body,status);
    }


    //status 201, message : 객체, map_custom2
    public static ResponseEntity<Map<String,Object>> responseMessage(HttpStatus status, Object o){
        Map<String, Object> body= new HashMap<>();
        body.put("status",Integer.toString(status.value()));
        body.put("message",o );
        return new ResponseEntity<>(body,status);
    }


//    매서드 체이닝 방식 : ResponseEntity의 클래스메서드 사용
    // status code:200
    @GetMapping("chaining1")
    public ResponseEntity<Member> chaining1(){
          Member member = new Member("apple","pear","1234");
          return ResponseEntity.ok(member);
    }

    //예외
    @GetMapping("chaining2")
    public ResponseEntity<Member> chaining2(){
        return ResponseEntity.notFound().build();
    }


    @GetMapping("chaining3")
    public ResponseEntity<Member> chaining3(){
        Member member = new Member("apple","pear","1234");
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }



}
