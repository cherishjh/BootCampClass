package C15AnonymousLambda;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class C1504ComparableComparator {
    public static void main(String[] args) {
// 자바에서는 비교를 위한 인터페이스가 대표적으로 2개: Comparable, Comparator
//       Comparable 인터페이스에는 compareTo메서드가 선언, 그리고 java 의 많은 클래스에서 구현하고 있음
//       일반적으로 클래스 내에서 직접 구현해서 사용하는 방식
//       Comparator  인터페이스에는 compare 메서드가 선언. => 일반적으로 익명객체를 만들어서 활용

//      두 문자열의 각 문자를 앞에서부터 순차적으로 비교
//      문자열의 자릿수의 차이가 발생할때 그 문자의 유니코드 값의 차이를 반환
       /* String a = "hello";
        String b = "horld";
        System.out.println(a.compareTo(b));
        List<String> myList = new ArrayList<>();
        myList.add(a);
        myList.add(b);
        Collections.sort(myList); //오름차순    Comparable 의 compareTo 메서드를 통해 정렬
        Collections.sort(myList, Comparator.reverseOrder());

        Integer intA = 1;
        Integer intB = 2;
        System.out.println(intA.compareTo(intB));*/

//    Student 객체 정렬
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Jessi",10));
        studentList.add(new Student("Tom",10));
        studentList.add(new Student("Fedex",10));

        //방법1: Comparable 인터페이스 상속 후 compareTo 메서드 구현, 매개변수 1개
        //나이로 정렬
       /* studentList.sort((o1,o2) -> o1.getAge()-o2.getAge());*/  //o2.getAge()-o1.getAge(); 내림차순
           /* @Override
            public int compare(Student o1, Student o2) {
//              기본은 오름차순 정렬하려고 시도
//                01.getAge()가 더 작은 숫자다라고 가정
                return o2.getAge()-o1.getAge(); // 내림차순
//                     o1.getAge() -o2.getAget(); // 오름차순  기본적으로 음수로
            }
        });*/
        /*System.out.println(studentList);*/
        //이름으로 정렬
        /*studentList.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));  //이름으로 오름차순
        studentList.sort((o1,o2) -> o2.getName().compareTo(o1.getName()));  //이름으로 오름차순
        System.out.println(studentList);*/
        //글자길이 수로 오름차순 정렬
        /*String[] stArr={"hello","java","C++","world"};
        Arrays.sort(stArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
        Arrays.sort(stArr,((o1, o2) -> o1.length()-o2.length()));
        System.out.println(Arrays.toString(stArr));*/
//      Priority Queue 글자 길이 내림차순
       /* Queue<String> myQue= new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });*/


        //방법2: Comparator 를 익명객체 방식으로 활용하여 정렬, 매개변수 2개
        Collections.sort(studentList);
        System.out.println(studentList);
/*

        for(int i=0; i<studentList.size();i++){
            System.out.println("Name: "+ studentList.get(i).getName() + " Age: "+ studentList.get(i).getAge());
        }

        System.out.println(studentList);
*/
        //thread 구현방식: thread 상속, Runnable 방식
        Thread t1= new Thread(() -> System.out.println("새로 만든 thread 입니다."));
        t1.start();
        //같은 말: 간결한 방법
        new Thread(() -> System.out.println("새로 만든 thread 입니다.")).start();

        System.out.println("main의 thread입니다.");


    }
}

    class Student implements Comparable <Student> {
        private String name;
        private int age;
        Student(String name,int age){
            this.name=name;
            this.age=age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }

//        조상클래스인 Object 클래스의 toString 을 overriding 하며 객체 호출 시 자동으로 toString 메서드에서 호출
        @Override
        public String toString(){
            return "이름은 "+ this.name+", 나이는 "+ this.age;
        }

        //Comparable<Student> : 제네릭
        @Override
        public int compareTo(Student o){
            return this.name.compareTo(o.getName());
        }
    }



