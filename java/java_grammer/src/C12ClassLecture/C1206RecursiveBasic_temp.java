package C12ClassLecture;
import java.util.Arrays;
public class C1206RecursiveBasic_temp {
    static int res = 0;
    public static void main(String[] args) {
//        int total = 0;
//        for (int i = 10; i >= 1; i--) {
//            total+= i;
//        }
//        System.out.println(total);
        System.out.println(add_acc(10));
        //누적 곱하기값 : 팩토리얼, 10*9...
        System.out.println(factorial(10));
        // 피보나치 for문
        int first = 1;
        int second = 1;
        for (int i = 2; i < 11; i++ ) {
            int third = first + second;
            first = second;;
            second = third;
        }
        //fibonacci
        System.out.println(fibonacci(9));
        //fibonacchi for문 DP
        System.out.println(Arrays.toString(fibonacciByFor(10)));

    }
    //메서드가 자기자신을 호출하는 메서드를 재귀함수라고 하고,
    //이러한 호출방식을 재귀호출이라고 한다.
    static int add_acc(int n) {
        if(n == 1) {
            return 1;
        }
        return n + add_acc(n-1);
    }
    static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
    static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    //DP 다이나믹 프로그래밍
    static int[] fibonacciByFor(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i= 2; i < arr.length; i++) {
            arr[i] = arr[i-1]+arr[i-2];
            System.out.println(arr[i]);
        }
        return arr;
    }

}
