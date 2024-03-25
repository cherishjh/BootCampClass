public class C03Operator {
    public static void main(String[] args) {
////  산술연산자
//        int num1=8, num2=3;
////      * 곱하기, / 나누기 , % 나머지
//        System.out.println("num1+num2 = " + (num1+num2));
//        System.out.println("num1-num2 = " + (num1-num2));
//        System.out.println("num1/num2 = " + (num1/(double)num2));
//        System.out.println("num1/num2 = " + (num1/num2));
//        System.out.println("num1*num2 = " + (num1*num2));
//        System.out.println("num1%num2 = " + (num1%num2));
//
////  대입연산자
//        int a = 10;
//        a += 20;
//        int n1=7, n2=7, n3=7;
//        n1 = n1-3;
//        n2 -= 3;
//        n3 = -3;
////        n3 = -3;  (n3=-3으로 다시 셋팅)
////  /=, %=
//        int n4 = 10; int n5 =10;
//        n4/=3;
//        n5%=3;
//        System.out.println("n4= " + n4 + " n5= " + n5);
////  증감연산자
/*//     ++x, --x
       int a = 5;
       a++;            // 이렇게 따로 정리하는게 안 헷갈림
       int b = a++;   //후위 연산자; 실행문 끝나고 증감
        System.out.println(a); // 6
        System.out.println(b); // 5

        a =5;
        b =++a;         // 전위연산자: 실행문이 끝나기 전에 증감
        System.out.println(a); //6
        System.out.println(b); //a*/
//  비교연산자
/*        ==, !=, >, >=, <, <=
        char1은 a를 할당, char2는 A를 할당
       char1, char2가 같은지 출력
        char char1 ='a';
        char char2 ='A';
        System.out.println(char1==char2);
        System.out.println(char1!=char2);*/
////  논리연산자 : &&, ||, !
/*        int num1=10; int num2=20;
        boolean result1, result2;
//        result1에 num1이 5보다 큰지 조건과 num1이 20보다 작은지 조건을 and조건을 통해 boolean 값 답기
//        result2에는 num2가 10보다 작은 조건과 num2가 30보다 작은 조건을 or 조건을 통해 boolean 값 담기
//        result1, result2 각각 출력
//        result2에 ! 담아서 출력
        boolean result1 = (num1 > 5) && (num1 < 20);
        result2 = (num2<10) || (num2<30);
        System.out.println(result1);
        System.out.println(!result2);
        // result1 = (num1 > 5) && !(num1 < 20);   이렇게도 쓸수 있고
        // result1 = !((num1 > 5) && (num1 < 20));*/
//
//  비트연산자 : &, 각 자리의 수가 모두 1인 경우만 1
        //0000101       0000110
        int a=5; int b=6;
        // AND(&) 연산: 비교하는 자리가 모두 1일때 1 반환
        System.out.println(a & b);  //4
        // OR (|)  연산: 비교하는 자리가 하나라도 1일때 1 반환
        System.out.println(a | b);  //7
        // XOR(^) 연산: 비교하는 자리가 일치 하면 0 반환
        System.out.println(a ^ b);  //3
        // NOT(~) 연산: 반대로 반환 0->1, 1->0
        System.out.println(~b);  //첫째자리는 음/양, 이 경우 b는 양수이므로 음수로 변환
        //시프트(<<,>>,=>) 연산:
        System.out.println(a<<2);  //0001010

     /*   int a = 13;     //00001101
        int b = 9;      //00001001
        while(b!=0){            //b=0이 되면 종료되는 조건 b!=0
            int same_index = a & b; //and 연산으로 구한 carry 생성
            a = a^b ;   //XOR 연산으로 구한 비트값 a에 할당
            b = same_index << 1 ;
        }*/
        //첫번째 cycle: a= 0100, b=10010
        //두번쨰 cycle:
        /*System.out.println(a);*/
    }
}
