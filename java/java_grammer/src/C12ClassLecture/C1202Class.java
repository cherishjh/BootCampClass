package C12ClassLecture;

import java.util.ArrayList;
import java.util.List;

public class C1202Class {
    public static void main(String[] args) {
        System.out.println(MyCalculator.sum(3, 2));
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.total);

/*//        A부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.total);


//        B부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.total);

        //--> 이렇게 되면 부서별 분리 안됨.
           -->클래스 변수를 공용으로 사용되다 보니, 변수와 메서드에 고유성이 보장되지 않음.*/
/*        //        A부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.totalA);


//        B부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.totalB);

        // 밑 MyCalculator 클래스에 아래처럼 더함
      *//*  static void sumAcc(int a){
            totalA+=a
        }*//*

        //--> 이렇게 되면 매번 만들어줘야함*/

        //        A부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.total);


//        B부서의 매출
        MyCalculator.sumAcc(10);
        MyCalculator.sumAcc(20);
        MyCalculator.sumAcc(30);
        System.out.println(MyCalculator.total);

//        클래스 변수를 공용으로 사용되다 보니, 변수와 메서드에 고유성이 보장되지 않음.
        System.out.println(MyCalculator.total);

        //        A부서의 매출
        MyCalInstance myCalA=new MyCalInstance();
        myCalA.sumAcc(10);
        myCalA.sumAcc(20);
        myCalA.sumAcc(30);
        System.out.println(myCalA.total);
        //        B부서의 매출
        MyCalInstance myCalB=new MyCalInstance();
        myCalB.sumAcc(10);
        myCalB.sumAcc(20);
        myCalB.sumAcc(30);
        System.out.println(myCalA.total);

    }
}




// 내부 클래스
        // public은 두개 있으면 안됨. public 클래스 명과 class 명이 같아야 함.
class MyCalculator{
    static int total =0;
    static int sum(int a, int b) {
        return a + b;
    }
    static void sumAcc(int a){
        total +=a;
    }
}

class MyCalInstance {
//   static이 붙어 있는 변수는 클래스 변수, static 이 붙어 있지 않으면 객체 변수
    int total = 0;

    static int sum(int a, int b) {
        return a + b;
    }

    /*static void sumAcc(int a) {
        total += a;
    }*/
    void sumAcc(int a){
        this.total+=a;
        //this 객체 그 자신을 의미
        // 이 상태에서는 생략 가능, 왜 붙여주냐면
         /*void sumAcc(int total){  //int total은 사용자가 입력한 total 값
             this.total+=total;
        }*/

    }
}