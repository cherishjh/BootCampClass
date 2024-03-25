package C13Inheritance;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;

public class C1303MethodOverriding {
//    상속 관계일때 부모클래스타입을 자식클래스 객체의 타입으로 지정 가능
//    Animal 클래스에 정의된 메서드만 사용가능하도록 제약이 발생
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();
    }
}
class Animal{
    void sound(){
        System.out.println("동물은 소리를 냅니다");
    }
}
class Dog extends Animal{
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}
class Cat extends Animal{
    @Override
    void sound() {
        System.out.println("야옹");
    }
}