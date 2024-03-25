package C12ClassLecture;

import java.util.Arrays;

public class C1206RecursiveBasic {
    public static void main(String[] args) {
//        피보나치 수열
        int n=10;
        int[] numbers = new int[n];
        //fibonacci를 for 문으로만(배열활용)
        //메모이제이션(기억알고리즘- DP)
        // 단계마다 계산 결과 값이 필요할때 메모이제이션 활용
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        System.out.println(Arrays.toString(numbers));

       /* int first = 1;
        int second = 1;
        for (int i = 2; i < 10; i++) {
            int third = first + second;
            first = second;
            second = third;
        }*/
//      factorial 함수


//        fibonacci 함수
        System.out.println(fibonacci(10));
    }
        static int fibonacci(int n){
        if(n==1 ) return 1;
        if(n==0 ) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
        }



// 팩토리얼 재귀 함수
    static int factorial(int n){
    if(n<=1) return 1;
    return n*factorial(n-1);
    }


}

