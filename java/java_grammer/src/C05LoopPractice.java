import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C05LoopPractice {
    public static void main(String[] args) {
//        짝수의 합 계산하기
//        1~20까지 짝수 합 출력
        /*for(int i=1; i<=20; i++){
            if(i%2==0){
                sum + =i;
            }

        }*/

      /*  int sum = 0;
        int[] arr ={1, 4, 2, 3, 4, 6, 7, 8, 9, 3, 4};
        for (int i = 0; i <arr.length; i++){
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}*/
        //enhanced for 문으로 작성할때
      /*  for (int a: arr){
            if(a%2==0){
                sum+=a;
            }
        }
        */
//숫자 뒤집기: int num=1234 int result=4321
/*    int num = 1234;
    int result = 0;
    while(true){
        int temp = num % 10;
        result = 10*result + temp;
        num /=10;      //이게 왜 버리는 거지
        if(num==0){
            break;
        }
    }*/
//    최대공약수 구하기 24, 36
//        1. 둘 중의 작은 값
//        2.
//        int a = 36;
//        int b = 24;
//        int num = a>b ? b:a;  //삼항연산자
//        int MDN = 0;
//        for (int i =1; i<=num;i++){
//           if(a%i==0 && b%i==0);
//           MDN=i;
//        }
////        최소공배수
//        int minNum = a/MDN * b/MDN * MDN;
//        int answer=0;
//          int n=50;
//        int i= (n>6) ? n : 6;
//        while(true){
//            if(i%6==0 && i%n==0) {
//                answer = i;
//                break;
//            } else{
//                i++;
//            }
//        }

//       라벨문 활용1
   /*     int[][] matrix={{1,2,3,4},{5,6,7},{8,9,11},{10,11,12,13,14}};
        int target = 11;
        loop1:
        for (int i=0; i<matrix.length;i++) {
            loop2:  //여기서는 루프2 라벨문 필요 없음
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println(i+","+j);
                    break loop1;
                }
            }
        }*/

//        1~20의 숫자가 있을때 이중에 약수가 5개 이상인 숫자 중에 가장 작은 값을 구하시오
        //1. 불필요한 추가 반복 X -> 라벨문
        //2.
        // 처음 생각해본 건 배열의 길이를 5개 이상인것으로 약수 개수 구하기;;;
              // 라벨문 활용 2

        int answer = 0;
        loop1:
        for (int i = 1; i < 20; i++) {
            int count = 0;
            loop2:
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (count >= 5) {
                    answer = i;
                    break loop1;
                }
            }
        }
        System.out.println(answer);
//
    }
}