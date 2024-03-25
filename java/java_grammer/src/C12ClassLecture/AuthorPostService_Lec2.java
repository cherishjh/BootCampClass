/*
package C12ClassLecture;
import java.util.*;

public class AuthorPostService_Lec2 {
public static void main(String[] args) {
    List<Author> authors = new ArrayList<>();
    List<Post> posts = new ArrayList<>();
            while(true){
                System.out.println("1번:회원가입, 2번:게시글작성, 3번:회원목록조회, 4번:회원상세조회, 5번:게시글상세조회 ");
                Scanner sc = new Scanner(System.in);
                int number = Integer.parseInt(sc.nextLine());
                switch (number){
                    case 1:
                        System.out.println("회원가입하실 이름을 입력해주세요");
                        String name = sc.nextLine();
                        System.out.println("회원가입하실 이메일을 입력해주세요");
                        String email = sc.nextLine();
                        Author author1 = new Author(name, email);
                        authors.add(author1);
                        break;
                    case 2:
                        System.out.println("작성자 email를 입력해주세요");
                        String author_email = sc.nextLine();
                        Author temp_author = null;
                        for(Author a : authors){
                            if(a.getEmail().equals(author_email)){
                                temp_author = a;
                                break;
                            }
                        }
                        if (temp_author==null){
                            System.out.println("없는 사용자입니다.");
                            continue;
                        }
                        System.out.println("게시글명을 입력해주세요");
                        String title = sc.nextLine();
                        System.out.println("게시글 내용을 입력해주세요");
                        String contents = sc.nextLine();
                        Post post1 = new Post(title, contents, temp_author);
//                    작성자의 객체의 post리스트에 포스트를 add
                        posts.add(post1);
                        temp_author.addPost(post1);
                        break;
//                    회원목록조회
                    case 3:
                        for(Author a : authors){
                            System.out.println(a.getEmail());
                        }
                        break;
//                    회원상세조회 : 이름, email, 작성글수
                    case 4:
                        System.out.println("author email를 입력해주세요");
                        String author_email2 = sc.nextLine();
                        Author temp_author2 = null;
                        for(Author a : authors){
                            if(a.getEmail().equals(author_email2)){
                                temp_author2 = a;
                                break;
                            }
                        }
                        System.out.println(temp_author2.getName() + " 이고 " + "작성글 수는 " + temp_author2.getPosts().size());

                        break;
//                    게시글상세조회
                    case 5:
                        System.out.println("post id를 입력해주세요");
                        Long post_id = Long.parseLong(sc.nextLine());
                        Post temp_post = null;
                        for(int i=0; i<posts.size(); i++){
                            if(posts.get(i).getId() == post_id){
                                temp_post = posts.get(i);
                                break;
                            }
                        }
                        System.out.println(temp_post.getTitle() + " " + temp_post.getAuthor().getEmail());
                        break;
                }

            }
        }
    }

    //엔티티
    class Author{
        private Long id;
        private String name;
        private String email;
        //    포스트 리스트 변수
        private List<Post> posts;
        static Long static_id = 0L;
        Author(String name, String email){
            static_id += 1;
            this.id = static_id;
            this.name = name;
            this.email = email;
            this.posts = new ArrayList<>();
        }
        void addPost(Post post){
            this.posts.add(post);
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

        public List<Post> getPosts() {
            return posts;
        }
    }
    class Post{
        private Long id;
        private String title;
        private String contents;
        private Author author;
        static Long static_id = 0L;
        Post(String title, String contents, Author author){
            static_id += 1;
            this.author = author;
//        this.author.addPost(this);
            this.id = static_id;
            this.title = title;
            this.contents = contents;
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getContents() {
            return contents;
        }

        public String getPostInfo(){
            return this.author.getEmail() + this.title + this.contents;
        }
        public Author getAuthor() {
            return this.author;
        }
    }

*/
