package C12ClassLecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AuthorPostService {
    public static void main(String[] args) {
    /*List<Author> authors= new ArrayList<>();
    List<Post> posts= new ArrayList<>();
    while(true){
        Scanner sc= new Scanner(System.in);
        System.out.println("회원가입 하실 이름을 입력해주세요");
        String name= sc.nextLine();
        Author author1= new Author();
        authors.add(author1);
        System.out.println("현재까지 가입한 회원의 수는 "+ authors.size());
    }*/
        Scanner sc=  new Scanner(System.in);
        List<Author> myauthors = new ArrayList<>();
        List<Post> myauthorPosts= new ArrayList<>();
        while(true){
            System.out.println("원하시는 서비스 번호를 입력하세요");
            String input= sc.nextLine();
            switch(input) {
                case "1":
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("회원 가입 서비스입니다.");
                    System.out.println("회원 정보를 입력하세요 (이름,이메일, 비밀번호 필수)");
                    String name = sc2.nextLine();
                    String email = sc2.nextLine();
                    String password = sc2.nextLine();
                    Author author1 = new Author(name, email, password);
                    System.out.println("가입 사용자의 id는 " + author1.getId() + author1.getName());
                    myauthors.add(author1);
                    System.out.println("현재까지 가입한 가입자는 " + myauthors.size());
                    break;
                case "2":
                    System.out.println("게시글 작성 서비스입니다.");
                    System.out.println("게시글을 작성해주세요 (이름, 이메일 필수)");
                    String name1 = sc.nextLine();
                    String email1 = sc.nextLine();
                    Long author_id = -0L;
                    for (int i = 0; i < myauthors.size(); i++) {
                        if (myauthors.get(i).getName().contains(name1)) {
                            author_id = myauthors.get(i).getId();
                        } else {
                            System.out.println("입력 정보를 확인하세요");
                        }
                    }
                    System.out.println("제목을 적어주세요");
                    String title1 = sc.nextLine();
                    System.out.println("내용을 적어주세요");
                    String contents1 = sc.nextLine();
                    Post post1 = new Post(title1, contents1, author_id);
                    myauthorPosts.add(post1);
                    System.out.println("정상 처리 되었습니다");
                    break;
                case "3":
                    System.out.println("회원 목록 조회 서비스입니다");
                    for (int a = 0; a < myauthors.size(); a++) {
                        System.out.println(myauthors.get(a).getId());
                        System.out.println(myauthors.get(a).getEmail());
                    }
//
                    break;
                case "4":
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("회원 상세 조회");
                    System.out.println("조회하고자 하는 id를 입력해주세요.");
                    int input_id = sc4.nextInt();
                    System.out.println("이름: " + myauthors.get(input_id-1).getName());
                    System.out.println("이메일: " + myauthors.get(input_id-1).getEmail());
                    int count = 0;
                    for (int i = 0; i < myauthorPosts.size(); i++) {
                        if (myauthorPosts.get(i).getAuthor_id() == input_id) {
                            count++;
                        }
                    }
                    System.out.println("작성 글 수: " + count);
                    break;
                /*System.out.println("id를 입력해주세요");
                Long author_id=Long.parseLong(sc4.nextLine());
                String detail_name="";
                String detail_email="";
                for(int i=0; myauthors.size(); i++){
                    if(auth)
                }
                for(Author a: myauthors){


                }*/

                case "5":
                    System.out.println("게시글 상세 조회 서비스입니다.");
                    System.out.println("조회하고자 하는 게시글 id를 입력하세요.");
                    int post_id=sc.nextInt();
                    Long temp=0L;
                    for(int i=0; i<myauthorPosts.size();i++) {
                        if (myauthorPosts.get(i).getId() == post_id) {
                            System.out.println(myauthorPosts.get(i).getTitle());
                            temp = myauthorPosts.get(i).getAuthor_id();
                        }
                    }
                    for(int b=0; b<myauthors.size(); b++) {
                        if(myauthorPosts.get(b).getId()==temp){
                            System.out.println((myauthors.get(b).getEmail()));
                        }
                        }
                    break;
            }
        }




    }
}

// entity: 데이터베이스에서는 table  ==> class 의 instance 레벨 = 데이터베이스의 테이블 컬럼
//                                   class 레벨 = 데이터베이스의 테이블 레벨 (class 명 = 테이블 명)
class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    static Long static_id=0L;

    Author(String name, String email, String password){
        static_id+=1;
        this.id=static_id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

class Post{
    private Long id;
    private String title;
    private String contents;
    private Long author_id;

    static Long static_id = 0L;

  /*  static Long static_postid;*/
    Post(String title, String contents,Long author_id){
        static_id+=1;
        this.id=static_id;
        this.title=title;
        this.contents=contents;
        this.author_id= author_id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public long getAuthor_id() {
        return author_id;
    }
}