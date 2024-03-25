package com.encore.board.Author.Service;

import com.encore.board.Author.Dto.AuthorDetailResDto;
import com.encore.board.Author.Dto.AuthorListResDto;
import com.encore.board.Author.Dto.AuthorSaveReqDto;
import com.encore.board.Author.Dto.AuthorUpdateReqDto;
import com.encore.board.Author.Repository.AuthorRepository;
import com.encore.board.Author.domain.Author;
import com.encore.board.Author.domain.Role;
import com.encore.board.Post.Repository.PostRepository;
import com.encore.board.Post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;
    //암호 복호화
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthorService(PasswordEncoder passwordEncoder, AuthorRepository authorRepository, PostRepository postRepository){
        this.passwordEncoder = passwordEncoder;
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
    }

/*    public void save(AuthorSaveReqDto authorSaveReqDto){
        Role role = null;
        if(authorSaveReqDto.getRole() ==null || authorSaveReqDto.getRole().equals("user")){
            role= Role.USER;
        } else {
            role=Role.ADMIN;
        }

        //일반 생성자 방식
//        Author author= new Author(authorSaveReqDto.getName(), authorSaveReqDto.getEmail(), authorSaveReqDto.getPassword(),role);
        //builder 패턴
        Author author = Author.builder()
                .name(authorSaveReqDto.getName())
                .email(authorSaveReqDto.getEmail())
                .password(authorSaveReqDto.getPassword())
                .build();

//        cascade.persist 테스트
//        부모 테이블을 통해 자식 테이블에 객체를 동시에 생성
*//*        List<Post> posts=new ArrayList<>();
        Post post= Post.builder()
                .title("안녕하세요"+ author.getName()+"입니다")
                .contents("반갑습니다. cascade 테스트 중입니다.")
                .author(author)
                .build();
//        post.addPost();*//*
        authorRepository.save(author);
    }*/

    public void save(AuthorSaveReqDto authorSaveReqDto){
        Optional<Author> authors= authorRepository.findByEmail(authorSaveReqDto.getEmail());
        if(authors.isPresent()){
            throw new IllegalArgumentException("중복 이메일");
        }
        Role role= null;
        if(authorSaveReqDto.getRole()==null || authorSaveReqDto.getRole().equals("user")){
            role= Role.USER;
        } else {
            role=Role.ADMIN;
        }

        //일반 생성자 방식
//        Author author= new Author(authorSaveReqDto.getName(), authorSaveReqDto.getEmail(), authorSaveReqDto.getPassword(),role);
        //builder 패턴
        Author author = Author.builder()
                .name(authorSaveReqDto.getName())
                .email(authorSaveReqDto.getEmail())
                .password(passwordEncoder.encode(authorSaveReqDto.getPassword()))
                .role(role)
                .build();

//        cascade.persist 테스트
//        부모 테이블을 통해 자식 테이블에 객체를 동시에 생성
/*        List<Post> posts=new ArrayList<>();
        Post post= Post.builder()
                .title("안녕하세요"+ author.getName()+"입니다")
                .contents("반갑습니다. cascade 테스트 중입니다.")
                .author(author)
                .build();
//        post.addPost();*/
        authorRepository.save(author);
    }

    public List<AuthorListResDto> findAll(){
        List<Author> authors= authorRepository.findAll();
        List<AuthorListResDto> authorListResDtoList= new ArrayList<>();
        for( Author a: authors){
            AuthorListResDto authorListResDto = new AuthorListResDto();
            authorListResDto.setId(a.getId());
            authorListResDto.setName(a.getName());
            authorListResDto.setEmail(a.getEmail());
            authorListResDtoList.add(authorListResDto);
        }
        return authorListResDtoList;
    }

    //findByEmail 함수
    public Author findByEmail(String email) throws EntityNotFoundException{
        Author author= authorRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        return author;
    }

   /* public Author findById(Long id){
        Author author= authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return author;
    }
*/
    //ControllerAdvice
    public Author findById(Long id){
        Author author= authorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("author not found"));
        return author;
    }

    //애 둘 차이가 뭐지?


    public AuthorDetailResDto findAuthorDetail(Long id){
        Author authorDetails= authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        String role = null;
        if(authorDetails.getRole() == null || authorDetails.getRole()==Role.USER){
            role= "일반 유저";
        } else {
            role="관리자";
        }
        authorDetailResDto.setId(authorDetails.getId());
        authorDetailResDto.setName(authorDetails.getName());
        authorDetailResDto.setEmail(authorDetails.getEmail());
        authorDetailResDto.setPassword(authorDetails.getPassword());
//        authorDetailResDto.setRole(authorDetails.getRole().toString());
        authorDetailResDto.setRole(role);
        authorDetailResDto.setCreatedTime(authorDetails.getCreatedTime());
        authorDetailResDto.setPostCount(postRepository.findByAuthor_id(authorDetails.getId()).size());
        return authorDetailResDto;
    }

    public void delete(long id){
//        authorRepository.delete(this.findById(id));/
        authorRepository.deleteById(id);
    }

    public void update(Long id, AuthorUpdateReqDto authorUpdateReqDto){
        Author author = this.findById(id);
        author.updateAuthor(authorUpdateReqDto.getName(),authorUpdateReqDto.getPassword());
      //명시적으로 save를 하지 않더라도 jpa의 영속성컨텍스트를 통해
//    //객체에 변경이 감지(dirty checking)되면 트랜잭션이 완료되는 시점에 save 된다
        /*  authorRepository.save(author);*/  //dirty checking ->
    }
}
