package C12ClassLecture;

public class C1201Method {
    public static void main(String[] args) {
// for문 이용해서 1~10까지 total 값 출력
        int total = 0;
        for (int i = 1; i < 11; i++) {
            total += i;
        }
        System.out.println(total);


//      코드의 중복이 발생하므로, 코드의 반복 피하기 위해 특정 기능집합을 별도로 분리
        sum_acc(100, 200);

//  같은 클래스 내 메서드들 사이에서 호출은 static매서드라 할지라도 클래스명 생략 가능
        System.out.println(C1201Method.sum_acc(1, 10));
//        메서드 구성 요소: 매개변수, 반환타입, 접근제어자, 클래스메서드 여부(static)
    }

    // void 리턴 타입: 리턴 타입 없는 것
    // int String 등 리턴타입 명시

        static int sum_acc(int start, int end){
            int total2 = 0;
            for (int i = start; i <= end; i++) {
                total2 += i;
            }

//    return 키워드를 통해서 연산결과값을 반환
        return total2;
    }
}
