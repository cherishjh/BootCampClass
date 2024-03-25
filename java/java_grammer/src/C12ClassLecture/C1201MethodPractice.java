package C12ClassLecture;

public class C1201MethodPractice {
    public static void main(String[] args) {
//        소수: 1과 자기 자신을 제외해서는 약수가 없는것
//        소수인지 아닌지 판별하는 메서드 생성
//        리턴타입 boolean : 소수이면 true, 아니면 false
//        main 메서드에서 호출하여 테스트
        System.out.println(primeNumber(99));
    }

    static boolean primeNumber(int num) {
        //boolean answer=true;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
                //answer=false;
                //break;
            }
        }
        return true;
    }
    //               메서드가 return을 만나면 바로 종료
//                void 리턴 타입 메서드에서도 강제종료를 위해 return 사용 가능
    static void isPrimePrint(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println("소수가 아입니다");
                return;
            }
        }
        System.out.println("소수입니다.");
    }
}
