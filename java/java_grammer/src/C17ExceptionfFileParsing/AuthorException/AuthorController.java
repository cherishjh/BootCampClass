package C17ExceptionfFileParsing.AuthorException;

import java.io.IOException;
import java.util.*;

class AuthorController {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorService();
        while(true){
            System.out.println("1번:회원가입, 2번:로그인");
            Scanner sc = new Scanner(System.in);
            int number = Integer.parseInt(sc.nextLine());
            switch (number){
                case 1:
                    System.out.println("회원가입하실 이름을 입력해주세요");
                    String name = sc.nextLine();
                    System.out.println("회원가입하실 이메일을 입력해주세요");
                    String email = sc.nextLine();
                    System.out.println("비밀번호 입력해주세요");
                    String password = sc.nextLine();
                    Author author1 = new Author(name, email, password);
                    try {
                        authorService.register(author1);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("login 하실 이메일입력해주세요");
                    String author_email = sc.nextLine();
                    System.out.println("login 하실 password를 입력해주세요");
                    String author_password = sc.nextLine();
                    Optional<Author> loginedAuthor = Optional.empty();
                    try {
                        loginedAuthor = authorService.login(author_email, author_password);
                        System.out.println(loginedAuthor.get().getName() + "님 환영합니다.");
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }
}
