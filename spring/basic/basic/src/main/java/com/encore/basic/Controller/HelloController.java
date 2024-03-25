package com.encore.basic.Controller;


import com.encore.basic.domain.Hello;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

//@RestController : 프론트 프레임워크가 따로 있을때 data만 반환 --> @ResponseBody 붙인것과 같음 ; 모든 요청에 RestController 사용
//http 통신을 가능하게 함.
@Controller
//클래스 차원에서 url 경로를 지정하고 싶다면 @RequestMapping을 클래스 위에 선언하면서 경로 지정.
@RequestMapping("hello")  //rqmapping
public class HelloController {

    //@ReponseBody가 없고 return 타입이 string 이면 templates 밑에 html 파일 리턴
    // data 만을 return 하면 @ResponseBody를 붙인다.  --> CSR, restApi,
    //public String 에 String 대신 객체가 들어가면 json 형태로 return 된다.

    @GetMapping("string")
//    @RequestMapping(value="string", method = RequestMethod.GET)
    @ResponseBody
    public String helloString() {
        return "hello_string";
    }

    @GetMapping("json")
    @ResponseBody
    public Hello helloJson() {
        Hello hello = new Hello();
        hello.setName("kitkat");
        hello.setPassword("s1234");
        hello.setEmail("kk@naver.com");
        //Spring에서 json parsing은 objectMapper로 -> 내장되어 있음
        System.out.println(hello);
        return hello;
    }


    @GetMapping("screen")
    public String helloScreen() {
        return "screen";
    }

   /* @GetMapping("screen-model")
    public String helloScreenModel(Model model){
//        화면에 data를 넘기고 싶을때는 model 객체 사용
//        model에 key:value 형식으로 전달
        model.addAttribute("myData","kitkat");
        return "screen";
    }*/


    @GetMapping("screen-model-param")
    public String helloScreenModelParam(@RequestParam(value = "name") String inputName, Model model) {
//    ?name=green 의 방식으로 호출(parameter 호출 방식)
//        화면에 data를 넘기고 싶을때는 model 객체 사용
//        model에 key:value 형식으로 전달
        model.addAttribute("myData", inputName);
        return "screen";
    }
    //param-> int 형태로 할떄
  /*  public String helloScreenModel(@RequestParam(value = "id") int inputName, Model model){
        model.addAttribute("myData",inputName);
        return "screen";
    }*/


    //    pathvariable 방식은 url을 통해 자원의 구조를 명확하게 표현할 수 있어
//    좀 더 restFul API 디자인에 적합 (보다 현대적인 방식)
    @GetMapping("screen-model-path/{id}")
    public String helloScreenModelPath(@PathVariable int id, Model model) {
        model.addAttribute("myData", id);
        return "screen";
    }

    //  Form 태그로 x-www 데이터 처리
    @GetMapping("form-screen")
    /*  @PostMapping("/form-post-handle")*/      // form post 처리
    public String formScreen() {
        return "formScreen";
    }

    @PostMapping("/form-post-handle")
    @ResponseBody
//  form 태그를 통한 body의 데이터 형태가 key1=value1&key2=value2
    //form 태그와 param이 같은 형식을 사용해서 param으로 form을 받음
    public String formPostHandle(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "email") String email) {

        System.out.println("이름 : " + name);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        return "정상처리";
    }

    @PostMapping("/form-post-handle2")
    @ResponseBody
//    Spring에서 Hello클래스의 인스턴스를 자동 매핑하여 생성
//    form-data 형식 즉, x-www-url 인코딩 형식의 경우 사용
//    이를 데이터 바인딩이라 부른다(Hello 클래스에 setter 필수)2
    public String formPostHandle2(Hello hello) {             //hello는 RequestParam 대신에
        System.out.println(hello);
        return "ok";
    }


    //   json 데이터 처리
    @GetMapping("json-screen")
    public String jsonScreen() {
        return "hello-json-screen";
    }

    @ResponseBody
    @PostMapping("/json-post-handle1")
    //@RequestBody는 json으로 post 요청이 들어왔을때 body에서 data를 꺼내기 위해 사용
    public String jsonPostHandle1(@RequestBody Map<String, String> body) {
        System.out.println("이름 : " + body.get("name"));
        System.out.println("비밀번호 : " + body.get("password"));
        System.out.println("이메일 : " + body.get("email"));
        Hello hello = new Hello();
        hello.setName(body.get("name"));
        hello.setPassword(body.get("password"));
        hello.setEmail(body.get("email"));
        return "ok";
    }

    @ResponseBody
    @PostMapping("/json-post-handle2")
    public String jsonPostHandle2(@RequestBody JsonNode body) {
        Hello hello = new Hello();
        hello.setName(body.get("name").asText());
        hello.setPassword(body.get("password").asText());
        hello.setEmail(body.get("email").asText());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/json-post-handle3")
    public String jsonPostHandle3(@RequestBody Hello hello) {
        System.out.println(hello);
        return "ok";
    }

    @ResponseBody
    @PostMapping("httpservlet")
    public String httpServletTest(HttpServletRequest req) {
        // HttpServletRequest 객체에서 header 정보 추출
        System.out.println(req.getContentType());
        System.out.println(req.getMethod());                     //post mapping에서 이미 한번 걸러주고 있어서 상위 2개는 쓸일이 많이 없음 (?)
//        session: 로그인(auth) 정보에서 필요한 정보값을 추출할때 많이 사용
        System.out.println(req.getSession());
        System.out.println(req.getHeader("Accept"));

//    HttpServletRequest 객체에서 body 정보 추출
        System.out.println(req.getParameter("test1"));
        System.out.println(req.getParameter("test2"));
//    req.getReader()를 통해 BufferedReader로 받아 직접 파싱

        return "ok";
    }


    //json 데이터 처리
    @GetMapping("/hello-servlet-jsp-get")
    public String helloServletJspGet(Model model){
        model.addAttribute("myData", "jsp test data");
        return "hello-jsp";
    }

    public void helloBuilderTest(){
        Hello hello = Hello.Builder()
                .email("name@naver.com")
                .name("name")
                .password("password")
                .build();
    }


}

