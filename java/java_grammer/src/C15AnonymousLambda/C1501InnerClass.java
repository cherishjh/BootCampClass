package C15AnonymousLambda;

public class C1501InnerClass {
    //static 내부 클래스
//    이 클래스는 C1501InnerClass의 정적멤버처럼 활용

    public static void main(String[] args) {
        MemberInnerClass.StaticInnerClass si= new MemberInnerClass.StaticInnerClass();
    }
}
//일반내부클래스
class MemberInnerClass{
    static class StaticInnerClass{
        private int data;
        void display(){
            System.out.println("data 값은"+ data+ " 입니다.");
        }
    }
}
