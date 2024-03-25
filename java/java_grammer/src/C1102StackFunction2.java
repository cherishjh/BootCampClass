public class C1102StackFunction2 {
    public static void main(String[] args) {
            System.out.println("main 함수 시작");
            System.out.println(function1(1));
            System.out.println("main 함수 끝");
        }
        static int function1(int a){     //void : 빈값   // int: return 타입을 int로 받음
            System.out.println("function1시작");
            System.out.println("function1끝");
            return function1(a*2);
        }
        static int function2(int a) {
            System.out.println("function2시작");
            System.out.println("function2끝");
            return a*2;

        }
    }

