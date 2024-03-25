package C15AnonymousLambda;

import java.sql.SQLOutput;

public class C1503LambdaExpression {
    public static void main(String[] args) {
//      실행문이 1개 일때는 {}제외하고 return이 생략 가능
//      실행문 2개 이상일때는 {} 포함하여 return 필요
        LambdaInterface li = (a, b) -> System.out.println(a + b);
        li.makeString("멍멍", "야옹");

        LambdaInterface2 li2 = (a, b, c) -> {
            String answer = a + b;
            return answer;
        };
        System.out.println(li2.makeString("애옹","슈가",10));
    }
}
interface LambdaInterface{
    void makeString (String a, String b);
}

interface LambdaInterface2{
    String makeString(String a, String b, int c);
}
