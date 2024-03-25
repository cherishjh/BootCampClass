package com.encore.classProject_ordering.security;

import com.encore.classProject_ordering.common.ErrorResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthFilter extends GenericFilter {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            String bearerToken = ((HttpServletRequest)servletRequest).getHeader("Authorization");
            if(bearerToken!=null){
                if(!bearerToken.startsWith("Bearer ")) {
                    throw new AuthenticationServiceException("token의 형식에 맞지 않습니다.");
                }
                //    bearer 토근에서 토큰값 추출
                String token= bearerToken.substring(7);
//    filter 검증할때 secretKey("mysecret") 필요 ; 검증에는 다양한 방법 가능
//    추출된 토큰을 검증 후 Authentication 객체 생성

//              token 검증 및 claims 추출
                //parse: 추출
                Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//               Authentication 객체를 생성하기 위해 userDetails 생성
                List<GrantedAuthority> authorities= new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_"+claims.get("role")));
                UserDetails userDetails= new User(claims.getSubject(),"",authorities);
                Authentication authentication= new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

//            filterchain에서 그 다음 filtering 으로 넣어가도록 하는 메서드
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            extracted((HttpServletResponse) servletResponse, e);
        }
    }

    private static void extracted(HttpServletResponse servletResponse, Exception e) throws IOException {
        HttpServletResponse response = servletResponse;
        response.setStatus(HttpStatus.UNAUTHORIZED.value());        //.value() : 숫자로 꺼낼 수 있게 함
        response.setContentType("application/json");
        response.getWriter().write(ErrorResponseDto.makeMessage(HttpStatus.UNAUTHORIZED, e.getMessage()).toString());
    }
}
