import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class C05LoopStatements {
    public static void main(String[] args) {
//  while 문    예제: 2~10까지 출력
      /*  int a=2;
        while (a<11){
            System.out.println(a);
             a++;
        }
*/
      /*  while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("구구단 단수를 입력해주세요");
            int input = sc.nextInt();
            int a = 1;
            while (a <= 9) {
                System.out.println(input + "X" + a + "= " + input * a);
                a++;
            }
        }*/
//        도어락키 if 문 예제 : 비밀번호를 맞추면 반복이 종료되고 , 그렇지 않으면 지속적으로 실행
 /*       while (true) {
            String answer = "1234";
            Scanner sc = new Scanner(System.in);
            System.out.println("비밀번호를 입력해주세요");
            String input = sc.nextLine();
            if (answer.equals(input)) {
                System.out.println("문이 열렸습니다.");
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다");
            }
        }*/
//        입력횟수 5회 제한, 5회 이후 '입력횟수 초과했습니다'
        /*
            int a=0
            while (true) {
            String answer = "1234";
            Scanner sc = new Scanner(System.in);
            System.out.println("비밀번호를 입력해주세요");
            String input = sc.nextLine();
            if (answer.equals(input)) {
                System.out.println("문이 열렸습니다.");
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다");
            }
            a++;
            if(a==5){
            System.out.println("입력횟수를 초과했습니다");
            break;
        }*/


        /*String answer = "1234";
        Scanner sc = new Scanner(System.in);
        System.out.println("비밀번호를 입력해주세요");
        String init = sc.nextLine();
        while (answer.equals(init)==false) {
            System.out.println("비밀번호를 입력해주세요");
            String i = sc.nextLine();
            ???????????????????????????????????//
            왜 안될까 궁금쓰..*/

//        }
//  Do while 문
//        int a = 0;
//        do {
//            a++;
//            System.out.println(a);
//        } while (a <= 10);

        //for 문을 통해 2~10 출력
       /* for (int a = 2; a < 11; a++) {
            System.out.println(a);
        }*/
//  for문의 continue를 사용해서 홀수만 출력되도록 (1~10) (짝수만, a%2!=0)
//        for(int a=1; a<11;a++) {
//            if(a%2==0){
//                continue;
//            }
//            System.out.println(a);
//        }
//    }

        //enhanced for 문 : 배열과 enhanced for 문
//        int[] myArr = {1, 5, 7, 9, 10};
//        일반 for 문
       /* for (int i = 0; i < 5; i++) {
            System.out.println(myArr[i]);
        }
*/
//        enhanced for 문
       /* for(int a : myArr){
            System.out.println(a);
        }*/
//        일반 for 문을 통해 myArr의 값에 10을 더한 뒤에 출력
   /*     for (int a = 0; a < myArr.length; a++) {
            myArr[a] += 10;
        }
        System.out.println(Arrays.toString(myArr));
*/
//        enhanced for 문으로 myArr의 값에 10을 더한 뒤에 출력
        /*for(int i: myArr){
            i+=10;
        }
        System.out.println(Arrays.toString(myArr));   //이거 안됨.. */

//        자바의 유효 범위 : {} 안의 값이 유효함
/*
        int num = 10;
        if (num > 1) {
            int abc = 20;
            num = 20;
        }
        System.out.println(num);   // if 문 밖에서 선언된 변수값을 if 안에서 접근하여 접근하는 것은 가능.
//        System.out.println(abc);    // if 문 안에서 정의된 변수는 밖에서 인지 불가
*/


//  다중반복문
//    구구단 예제 2~9단 출력하되 몇단입니다 라고 멘트 추가
       /* for (int a = 2; a < 11; a++) {
            System.out.println(a + "단 입니다.");
             while (int i < 10) {
                System.out.println(a + "X" + i + "= " + a * i);
                i++;
            }
        }
*/
     /*   for(int num=2; num<10; num++){
            System.out.println(num+"단입니다.");
            for(int i=1;i<10;i++){
                System.out.println(num + "X" + i + "= " + num * i);
            }
        }*/

//  2중 for 문을 통해 배열 접근
     /*   int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}};
//        System.out.println(arr[0][0]);  //1
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.println(arr[i][j]);
                }
        }*/

//  라벨문
        //기본 문법
      /*  loop1:
        for () {
            loop2:
            for () {

                break loop2;
            }
        }
        */
        loop1:
        for (int i = 0; i < 5; i++) {
            loop2:
            for (int j = 0; j < 5; j++) {
                System.out.println("hello world");
                if (j == 2) {
                    break;   //break loop1 = 3번, break(loop2)= 15번
                }
            }
        }
//       라벨문 활용
    }
}



