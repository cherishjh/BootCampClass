import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C04IF_Statements {
    public static void main(String[] args) {

        // 도어락키 if 문 예제
//        int answer =1234;
//        System.out.println("비밀번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        if (answer==input){
//            System.out.println("문이 열렸습니다.");
//        }   else{
//            System.out.println("비밀번호가 틀렸습니다");
//        }

//        String answer =1234;
//        System.out.println("비밀번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextInt();
//        if (answer.equals(input)){
//            System.out.println("문이 열렸습니다.");
//        }   else{
//            System.out.println("비밀번호가 틀렸습니다");
//        }


//        int password = 1234;
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        if( input == password){
//           System.out.println("문이 열렸습니다.");
//        } else {
//            System.out.println("비밀번호가 틀렸습니다.");
//        }


        //  묵시적 타입 변환
//  a:97, A:65, B:66 ..(순차적인 값을 가짐)
//  사용자에게 알파벳을 아무거나 입력 받고, 그 알파벳이 대문자인지 소문자인지 판별
/*        Scanner sc = new Scanner(System.in);
        char input = sc.nextLine().charAt(1);
        if(input >= 'a' && input <= 'z') {      //'a' =< input <= 'z' 자바에서는 이 문장 안됨.
            System.out.println(("소문자입니다.");
        } else if (input >= 'A' && input<='Z'){
            System.out.println("대문자입니다.");
        } else {
            System.out.println("알파벳이 아닙니다.");
        }*/


//        if(input>=97){
//            System.out.println("소문자입니다.");
//        }else {
//            System.out.println("대문자입니다.");
//        }

//  버스카드 예제
        // 내 돈이 얼마나 있는지 입력
        // 버스요금이 1500원
        // 가진돈이 적으면 '탑승할 수 없습니다'
        // 돈이 있으면 '정상처리' 출력
        // 도난카드 여부 boolean; 입력 받지 말고 변수값으로 설정
/*        Scanner sc = new Scanner(System.in);
        int bus_fee = 1500;
        int input = sc.nextInt();
        boolean stolen = false;
        if (input >= bus_fee && stolen == false) {
            System.out.println("정상처리 되었습니다.");
        } else if (input < bus_fee && stolen == false) {
            System.out.println("잔액이 부족합니다.");
        } else {
            System.out.println("탑승이 불가합니다.");
        }*/

/*
      int myMoney= 100000;
        boolean isStolen = false;
        System.out.println("도난카드입니까?");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals("예")){
            isStolen = true;
            }
        if (myMoney<1500 || isStolen ==true){
            System.out.println("탑승불가입니다.");
        }else {
            System.out.println("정상 탑승되었습니다");
        }
        if (myMoney>= 1500 && isStolen==false){
            System.out.println("정상탑승되었습니다");
        } else {
            System.out.println("탑승불가입니다.");
        }
*/

//  삼항연산자
//        String answer = "1234";
//        System.out.println("비밀번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        String result = answer.equals(input)?
//                "문이 열렸습니다." :
//                "비밀번호가 틀렸습니다";
//        System.out.println(result);
//
// if/else if/ else 문
        Scanner sc = new Scanner(System.in);
     /*   System.out.println("현재 갖고 있는 금액을 입력하세요");
        int myMoney = sc.nextInt();
        if (myMoney >= 10000){
            System.out.println("모든 방법 가능");
        } else if (myMoney>=3000){
            System.out.println("택시 탑승 불가");
        }else if (myMoney>=2000){
            System.out.println("킥보드만 가능");
        } else{
            System.out.println("걸어가기");
        }*/

      /*  int myMoney = 10000;
        int taxiFee = 10000;
        int busFee = 3000;
        int kickboardFee = 2000;

        if (myMoney >= taxiFee){

        }*/

       /* if (myMoney >= 10000){
            System.out.println("모든 방법 가능");
        }
        if (myMoney>=3000 && myMoney <= 10000){
            System.out.println("택시 탑승 불가");
        }
        if (myMoney>=2000 && ){
            System.out.println("킥보드만 가능");
                }
        이렇게 if는 독립적이라서 이 경우 순차적으로 하지 않고 && 조건으로 범위 잘 명시하면 순서는 무작위여도 정확한 결과값 출력하는데 상관이 없음
*/

//  Switch 문
//      고객센터 출력 예제
//        원하시는 번호를 입력해주세요
//         1. 대출서비스입니다.   2.예금  3.적금   0.상담사연결  그외: 잘못누르셨습니다.
/*
        System.out.println("안내 받고 싶은 번호를 눌러주세요.");
        int input= sc.nextInt();
        switch (input) {
            case 1 : System.out.println("대출서비스입니다.");
                break;
            case 2 :
                System.out.println("예금");
                break;
            case 3:
                System.out.println("적금");
                break;
            case 0:
                System.out.println("상담사 연결");
                break;
            default: System.out.println("잘못 누르셨습니다. 다시 입력해주시길 바랍니다.");
                break;
                }
                // break 가 없으면 조건 안 따지고 바로 실행
*/





    }
}






