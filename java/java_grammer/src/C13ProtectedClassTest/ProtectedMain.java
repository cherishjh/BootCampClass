package C13ProtectedClassTest;

import C13Inheritance.C1304ProtectedClass;

public class ProtectedMain {
    public static void main(String[] args) {
        C1304ProtectedClass test= new C1304ProtectedClass();
       /* System.out.println(test.st1);
        System.out.println(test.st2);
        System.out.println(test.st3);  */
        System.out.println(test.st4);       //다른 패키지에서는 public 변수만 접근 가능

    }
}



