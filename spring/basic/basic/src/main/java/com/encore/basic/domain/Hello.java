package com.encore.basic.domain;
import lombok.*;

@Getter
@Setter
@Data // getter, setter 및 toString, equals 등 사전 구현
@NoArgsConstructor
public class Hello {
    private String name;
    private String email;
    private String password;

//    builder 패턴 직접 구현
    //일반적인 생성자 구현
    public Hello(MyBuilder myBuilder){
        this.name=myBuilder.name;
        this.email=myBuilder.email;
        this.password=myBuilder.password;
    }
    public static MyBuilder Builder(){
        return new MyBuilder();
    }

    public static class MyBuilder{
        private String name;
        private String email;
        private String password;

        public MyBuilder name(String name){
            this.name=name;
            return this;
        }
        public MyBuilder email(String email){
            this.email=email;
            return this;
        }
        public MyBuilder password(String password){
            this.password=password;
            return this;
        }

        public Hello build(){
            return new Hello(this);
        }

    }

}
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}*/
