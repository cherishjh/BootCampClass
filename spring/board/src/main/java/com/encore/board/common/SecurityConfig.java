package com.encore.board.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  //해당 annotation은 spring security 설정을 customizing 하기 위해

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain myFilter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity

                //csrf 보안 공격에 대한 설정은 하지 않겠다는 의미
                .csrf().disable()
                // 특정 url에 대해서는 인증처리 하지 않고, 특정 url 에 대해서는 인증처리 하겠다.
                // (ex.로그인 화면, 회원 가입, 홈 화면: 인증처리 하지 않음)
                .authorizeRequests()
                //인증 미적용 url 패턴
                    .antMatchers("/", "/author/register", "/author/login-page")
                .permitAll()
                // 그 외 요청은 모두 인증 필요
                    .anyRequest().authenticated()
                .and()
                //만약에 세션을 사용하지 않으면 아래 내용을 설정
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .formLogin()
                    .loginPage("/author/login-page")
                //스프링 내장 메서드를 사용하기 위해 /doLogin url을 사용
                    .loginProcessingUrl("/doLogin")
                        .usernameParameter("email")
                        .passwordParameter("pw")
                    .successHandler(new LoginSuccessHandler())
                .and()
                .logout()
                    .logoutUrl("/doLogout")
                .and()
                .build();
    }
}






