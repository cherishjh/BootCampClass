package com.encore.board.Post.Service;

import com.encore.board.Author.Dto.AuthorDetailResDto;
import com.encore.board.Author.Dto.AuthorListResDto;
import com.encore.board.Author.Dto.AuthorUpdateReqDto;
import com.encore.board.Author.Repository.AuthorRepository;
import com.encore.board.Author.domain.Author;
import com.encore.board.Author.domain.Role;
import com.encore.board.Post.Dto.PostDetailsResDto;
import com.encore.board.Post.Dto.PostListResDto;
import com.encore.board.Post.Dto.PostSaveReqDto;
import com.encore.board.Post.Dto.PostUpdateReqDto;
import com.encore.board.Post.Repository.PostRepository;
import com.encore.board.Post.domain.Post;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;


    @Autowired
    public PostService(AuthorRepository authorRepository, PostRepository postRepository){
        this.postRepository=postRepository;
        this.authorRepository=authorRepository;
    }

  /*  public void save(PostSaveReqDto postSaveReqDto){
        Author author= authorRepository.findByEmail(postSaveReqDto.getEmail()).orElse(null);
        Post post= Post.builder()
                .title(postSaveReqDto.getTitle())
                .contents(postSaveReqDto.getContents())
                .author(authorRepository.findByEmail(postSaveReqDto.getEmail()).orElse(null))
                .build();

        //더티체킹 테스트
//        author.updateAuthor("dirty checking", "1234");
        postRepository.save(post);
    }*/

    public void save(PostSaveReqDto postSaveReqDto,String email) throws IllegalArgumentException{
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email=authentication.getName();
//        Author author= authorRepository.findByEmail(email).orElse(null);
//        Author author= authorRepository.findByEmail(postSaveReqDto.getEmail()).orElse(null);
        Author author= authorRepository.findByEmail(email).orElse(null);
        LocalDateTime localDateTime = null;
        String appointment = null;
        if(postSaveReqDto.getAppointment().equals("Y") && !postSaveReqDto.getAppointmentTime().isEmpty()){
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            localDateTime= LocalDateTime.parse(postSaveReqDto.getAppointmentTime(),dateTimeFormatter);
            LocalDateTime now= LocalDateTime.now();
            if(localDateTime.isBefore(now)){
                throw new IllegalArgumentException("시간 정보 잘못 입력");
            }
            appointment="Y";
        }

        Post post= Post.builder()
                .title(postSaveReqDto.getTitle())
                .contents(postSaveReqDto.getContents())
//                .author(authorRepository.findByEmail(postSaveReqDto.getEmail()).orElse(null))
                .author(authorRepository.findByEmail(email).orElse(null))
//                .author(authorRepository.findByEmail(email).orElse(null))
                .appointment(appointment)
                .appointmentTime(localDateTime)
                .build();
        postRepository.save(post);
    }



/*    public List<PostListResDto> findAll(){
        List<Post> posts= postRepository.findAllFetchJoin();
        List<PostListResDto> postListResDtoList= new ArrayList<>();
        for(Post p: posts){
            PostListResDto postListResDto = new PostListResDto();
            postListResDto.setId(p.getId());
            postListResDto.setTitle(p.getTitle());
            postListResDto.setAuthor_email(
                    p.getAuthor()==null?"익명":p.getAuthor().getEmail());
            postListResDtoList.add(postListResDto);
        }
        return postListResDtoList;
    }*/

    //pageable
    //page 객체 내에 map을 지원하고 있음
  /*  public Page<PostListResDto> findAllJson(Pageable pageable){
        Page<Post> posts= postRepository.findAll(pageable);
        Page<PostListResDto> postListResDtoList
                = posts.map(p-> new PostListResDto(p.getId(),p.getTitle(),p.getAuthor()==null?"익명유저":p.getAuthor().getEmail()));

        return postListResDtoList;
    }
*/
    public Page<PostListResDto> findAll(Pageable pageable){
        Page<Post> posts= postRepository.findAll(pageable);
        Page<PostListResDto> postListResDtoList
                = posts.map(p-> new PostListResDto(p.getId(),p.getTitle(),p.getAuthor()==null?"익명유저":p.getAuthor().getEmail()));

        return postListResDtoList;
    }

    public Page<PostListResDto> findByAppointment(Pageable pageable){
        Page<Post> posts= postRepository.findByAppointment(null,pageable);
        Page<PostListResDto> postListResDtoList = posts.map(
                                                        p-> new PostListResDto(
                                                                p.getId(),
                                                                p.getTitle()
                                                                ,p.getAuthor()==null?"익명유저":p.getAuthor().getEmail()
                                                        )
                                                    );
        return postListResDtoList;
    }



    public Post findById(Long id) {
        Post post= postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return post;
    }

    public PostDetailsResDto findAuthorDetail(Long id) throws EntityNotFoundException{
        Post postDetails= postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        PostDetailsResDto postDetailsResDto = new PostDetailsResDto();
        postDetailsResDto.setId(postDetails.getId());
        postDetailsResDto.setTitle(postDetails.getTitle());
        postDetailsResDto.setContents(postDetails.getContents());
        postDetailsResDto.setCreated_time(postDetails.getCreatedTime());
//        authorDetailResDto.setRole(authorDetails.getRole().toString());
        return postDetailsResDto;
    }

    public void delete(long id){
//        authorRepository.delete(this.findById(id));/
        postRepository.deleteById(id);
    }

    public void update(long id, PostUpdateReqDto postUpdateReqDto){
        Post post = this.findById(id);
        post.updatePost(postUpdateReqDto.getTitle(),postUpdateReqDto.getContents());
        postRepository.save(post);
    }
}
