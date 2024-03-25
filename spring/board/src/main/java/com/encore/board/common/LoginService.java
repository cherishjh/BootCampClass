package com.encore.board.common;


import com.encore.board.Author.Repository.AuthorRepository;
import com.encore.board.Author.Service.AuthorService;
import com.encore.board.Author.domain.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoginService implements UserDetailsService {
    private final AuthorService authorService;
    public LoginService(AuthorService authorService){
        this.authorService=authorService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author= authorService.findByEmail(username);
        List<GrantedAuthority> authorities= new ArrayList<>();
        //ROLE_권한 이 패턴으로 스프링에서 기본적으로 권한 체크 (ex.ROLE_USER)
        authorities.add(new SimpleGrantedAuthority("ROLE_"+author.getRole().toString()));
        //매개변수: userEmail, userPassword, 권한(authorities)
        //해당 메서드에서 return 되는 user 객체는 session 메모리 저장소에 저장되어 계속 사용 가능
        return new User(author.getEmail(),author.getPassword(),authorities);
    }
}
