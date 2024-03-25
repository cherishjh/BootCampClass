public class C02Variables {
    public static void main(String[] args) {
//        byte num1 = 127;
//        byte num2 = -128;
//        num1++;
//        num2--;
//       System.out.println(num1);
//       System.out.println(num2);

//       실수: float, double(기본)
//        float f1 = 1.123456789f;
//        double b1 = 1.123456789;
//        System.out.println("f1 : " + f1);
//        System.out.println("b1 : " + b1);
//
////        부동소수점 오차 테스트
//        double double_num = 0.1;
////        미세오차는 조정되어 정상적으로 출력
//        System.out.println(double_num);

//        반복적인 연산시 오차가 확대되어 오차 확인 가능
//        for(초기식;조선식;증감식){ }
//        for(int i=0;i<100;i++){
//            System.out.println(i);
//        }
//        0.1을 특정 변수에 1000번 더해서 더한값 출력
//        double total = 0;
//        for(int i=0;i<1000;i++){
//            total= total + 0.1*10;
//        }
//            System.out.println(total/10);

//        저장할 때는 문자열 -> 연산할때는 정수로 변환 -> 최종결과는 실수로 반환
//        소수점이 갖는 특성때문에 실수 그대로 연산하면 오차가 발생함.
//        double d1 = 1.03;
//        double d2 = 0.42;
//        System.out.println(d1-d2);
//
//        BigDecimal myBig1 = new BigDecimal( "1.03");
//        BigDecimal myBig2 = new BigDecimal( "0.42");
//       System.out.println(myBig1.subtract(myBig2));

//       변환방식 BigDecimal이기 때문에 double로는 출력이 안될것임.. 그래서 double로 출력하는방법
//        BigDecimal myBig1 = new BigDecimal( "1.03");
//        BigDecimal myBig2 = new BigDecimal( "0.42");
//        double result = myBig1.subtract(myBig2).doubleValue();
//        System.out.println(result);
//
////       문자 char
//        char my_char = '가';
//        System.out.println(my_char);
//
//       boolean : true(1), false(0)
        boolean my_bool = true;
        System.out.println(my_bool);
        if (my_bool) {
            System.out.println("조건식이 참입니다");
//        }
//        int bool_num1 = 20;
//        int bool_num2 = 10;
//        if(bool_num1 > bool_num2){
//            System.out.println("조건식이 참입니다.");
//        }
//  묵시적 타입 변환
        char ch1 = 'a';
//        int ch1_num = ch1;
        int ch1_num = (int)ch1;  /*명시적 변환*/
        System.out.println(ch1_num);

//        int my_int1 =10;
////      int -> double
//        double my_double1 = my_int1;
//        System.out.println(my_double1);
//      에러 발생: my_int1 = my_double1;
//        double -> int 명시적 타입은 가능 : 소수점값 손실발생 가능성이 있다.
//        my_int1 = (int)my_double1;
//        double my_double2 = 7.2f;
//        System.out.println(my_double2);

//       명시적 타입변환
//        char my_char2 = 'b';
//        int char_num = (int) my_char2;

//        int a가 1이고 int b가 4일때 둘을 나눈 값을 int에 담아 출력, double에 담아 출력.
            int a = 1;
            int b = 4;
            int result1 = a / b;
            double result2 = a / b;
            System.out.println(result1);
            System.out.println(result2);
            double result3 = a / (double) b;
            System.out.println(result3);

            //변수와 상수 :: 다시 정리
            //선언과 동시에 초기화
            int a1 = 10;

            //변수값 변경
            a1 = 20;

            //선언만 한 뒤에 나중에 초기화
            int a2; //지역변수는 선언만 됐을때는 값이 0으로 초기화되지 않으나, 객체로 선언될때는 0으로 초기화
            a2 = 20;
                //객체로 만들때는 0으로 초기화
            int[] arr = new int[5];
            System.out.println(arr[0]);

            //상수는 값의 재할당이 불가능
            final int AGES = 20;
            // AGES = 30; 에러 발생

            //상수는 선언만 한 뒤에 나중에 초기화 하는 방식이 java8이전에는 안됐지만 이후 가능해짐
            final int AGES2;
            AGES2 = 20;
        }
    }
}

