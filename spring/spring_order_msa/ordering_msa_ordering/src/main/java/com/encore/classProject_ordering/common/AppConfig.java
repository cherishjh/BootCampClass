package com.encore.classProject_ordering.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
    Eureka 에 등록된 서비스 명을 사용해서 내부 서비스를 호출할수 있게 해주는 어노테이션

    ex) 오더에서 맴버로 접근할때 유레카가 포트번호를 알려준다. 이때 맴버 서버가 여러개라면?
    유레카가 어떤 맴버를 연결해줄지 몰라서 @LoadBalanced 를 사용해야 한다.


    */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
