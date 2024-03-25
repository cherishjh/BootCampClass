package C17ExceptionfFileParsing;

import java.util.Scanner;

public class C1701Exception {
    public static void main(String[] args) {
//ArithmeticException : 0으로 나눌때
        /*System.out.println("나눗셈 프로그램입니다. 숫자 10에 나눌 분모값을 입력해주세요");
        int num = 10;
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        //예외가 발생할 것으로 예상되는 코드에 try catch로 감싸준다.
        try {
            System.out.println("10에 " + input + "을 나누면 ");
            System.out.println(num / input + "입니다.");
            //catch에는 try 구문 안에서 발생 가능한 예외사항을 적어야 정상적으로 catch 가 된다.
        } catch (IllegalArgumentException e) {
            System.out.println("정상적이지 않은 입력값입니다.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눗셈이 불가 합니다.");
            // e 안에 예외 관련된 정보들이 들어있음.
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            //exception: 모든 예외의 부모 예외
            // 마지막에 삽입, 위에서 못 잡는 예외를 잡고 싶을때
            System.out.println("알수 없는 예외가 발생했습니다");
            e.printStackTrace();
        } finally {
            //finally는 많이 안 씀.
            // 반드시 실행되어야 하는 구문 삽입
        }
        System.out.println("감사합니다.");
*/

        //throw new, throws 예외
        //예제
        String password = "1234";
        try {
            login(password);
        } catch(IllegalArgumentException e){
            //e.getMessage는 login 메서드에서 throw new한 곳에서 넘어온 메세지
            System.out.println(e.getMessage());
        }
    }
    //unchecked exception에서 throw 하지 않아도 예외는 호출한 곳으로 전파
    // 이때에 throws를 하는 이유는 명시적으로 예외가 발생할 수 있음을 알리는 것일뿐

    //checked exception은 예외처리가 강제되고 해당 메서드에서 예외처리를 하든지 throw를 통해 호출한 곳에 위임
    //이때에 호출한 쪽에서는 예외처리가 강제된다.
    static void login(String password) throws IllegalArgumentException {
        if (password.length() < 10) {
            throw new IllegalArgumentException("비밀번호가 짧습니다.");
        }
    }
}



