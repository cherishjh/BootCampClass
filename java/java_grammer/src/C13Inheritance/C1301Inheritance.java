package C13Inheritance;

// extends 키워드를 통해 상속 관계를 표현    Inheritance가 Parents의 자식 클래스
public class C1301Inheritance extends Parents{
    int c=30;
    public static void main(String[] args) {
        C1301Inheritance ih=new C1301Inheritance();
        System.out.println(ih.c);
        System.out.println(ih.a);
//      자식 클래스여도 private 변수는 상속 및 접근이 불가
//        System.out.println(ih.b);


        ih.parentMethod();
        ih.childMethod();
    }
    void childMethod(){
        System.out.println("자식클래스입니다.");
    }
//    부모클래스의 매서드명을 동일하게 사용하므로서 메소드 오버라이딩(덮어쓰기)했다.
    @Override
    void parentMethod(){
        System.out.println("부모클래스가 아니라 자식클래스입니다.");
    }
}

    class Parents{
        int a=10;
        private int b=20;
        void parentMethod(){
            System.out.println("부모클래스입니다.");
        }

    }

