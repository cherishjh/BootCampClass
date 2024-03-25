package com.encore.classProject_ordering.order.controller;

import com.encore.classProject_ordering.order.dto.MemberDto;
import com.encore.classProject_ordering.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {
    private final String MEMBER_API = "http://member-service/";
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public TestController(
            OrderRepository orderRepository, RestTemplate restTemplate
    ) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test/restTemplate")
    public void restTemplate(){
        String url = MEMBER_API + "member/1";
        MemberDto memberDto = restTemplate.getForObject(url, MemberDto.class);
        log.info(memberDto.toString());

    }
}
