package C13ProtectedClassTest;

import C13Inheritance.C1304ProtectedClass;

public class ProtectedMain2 extends C1304ProtectedClass {
    public static void main(String[] args) {
        ProtectedMain2 test = new ProtectedMain2();
//        ProtectedMain2 를 객체로 받아야 protected 변수까지 접근 가능
        System.out.println(test.st3);
        System.out.println(test.st4);

        C1304ProtectedClass test2= new C1304ProtectedClass();
        /*System.out.println(test2.st3); */     //ProtectedClass 변수라서 "다른 패키지"에서 불러온 protected 변수는 못 가져옴
        System.out.println(test2.st4);
    }
}
