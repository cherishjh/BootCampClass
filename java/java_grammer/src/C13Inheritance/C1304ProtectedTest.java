package C13Inheritance;

public class C1304ProtectedTest {
    public static void main(String[] args) {
    C1304ProtectedClass test= new C1304ProtectedClass();
     /*   System.out.println(test.st1);*/    //st1이 ProtectedClass 의 private 변수라서 접근 안됨;
        System.out.println(test.st2);
        System.out.println(test.st3);
        System.out.println(test.st4);

    }
}