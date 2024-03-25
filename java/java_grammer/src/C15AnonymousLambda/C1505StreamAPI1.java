package C15AnonymousLambda;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C1505StreamAPI1 {
    public static void main(String[] args) {
        //int[] arr = {20, 10, 4, 12};
//        전통적인 방식의 데이터 접근방식
       /* for( int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }*/
//        데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
//        java에서 함수형 프로그래밍을 지원하기 위한 라이브러리 -> StreamApi
        /*Arrays.stream(arr)  //arr의 복사본
        Arrays.stream(arr).forEach();  //forEach: 순회하면서 변수를 집어넣음  ; 스트림의 각 요소를 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(a->System.out.println(a));*/
        //Arrays.stream(arr).sorted().forEach(a -> System.out.println(a));

        // 성능이 느리다. 최적화해야하는 상황이면 지양



//        스트림의 생성
        //String[] myString = {"HTML", "CSS", "JAVA", "PYTHON"};
//        스트림 <객체> : 제네릭 타입으로 stream 객체가 생성됨
        //Stream<String> stStream = Arrays.stream(myString);

        /*int[] intArr = {10, 20, 30, 40, 50};
        IntStream intStream = Arrays.stream(intArr);
        int[] intArr2 = intStream.filter(a -> a > 20).toArray();*/

//       참조변수의 스트림 변환의 경우 제네릭의 타입소거 문제 발생
//        제네릭의 타입소거란 java 버전의 호환성을 위해 제네릭 타입을 런타임시점에 제거하는 것을 의미
//        String[] stArr2= stStream.filter(a-> a.length()<=4).toArray(a->new String[a]);
//        메소드 참조 방식으로 표현하는 것이 더 일반적이다.
//        메소드 참조 방식: 클래스::매서드
        //String[] stArr2 = stStream.filter(a -> a.length() <= 4).toArray(String[]::new);
        //System.out.println(Arrays.toString(stArr2));

//        stream 중개연산 : filter, map, sorted, distinct
        //1. distinct : 중복제거 후 스트림 반환
        // int[] intArr={10,30,30,10,40,50};
        // 중복제거 후 총합 반환
        //int answer=Arrays.stream(intArr).distinct().sum();
        //int [] answer2=Arrays.stream(intArr).distinct().;
        //String [] stArr={"java", "python","C++", "java"};
        //중복 제거 후 새로운 배열 생성
        //String [] myArr=Arrays.stream(stArr).distinct().toArray(String[]::new);
        //중복제거하고 길이가 3개 이하 것으로 제한하고, 남은 배열의 길이의 총합
        //mapToInt를 통해 IntStream으로 변환
        /*IntStream mystream=Arrays.stream(stArr).distinct()
                .filter(a->a.length()<=3).mapToInt(a->a.length());*/
        //map은 stream 형식으로 반환되고 이 배열은 int 이기 때문에 Integer로 받아줘야 함.
        //Stream<Integer> mystream1=Arrays.stream(stArr).distinct().filter(a->a.length()<=3).map(a->a.length());

        //2. sorted: 정렬된 스트림 반환
        /* int [] arr = {4,1,2,3,6,7};*/
        //내림차순 정렬된 숫자 신규 배열 반환
        /*int [] newarr=Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(newarr));

        String [] test={"Merry", "Christmas","and","happy","happy","NewYear"};
        String [] merryX=Arrays.stream(test).sorted(Comparator.reverseOrder()).toArray(String[]::new);

        List<Integer> myList= new ArrayList<>(Arrays.asList(6,1,2,3,4,5,2));*/

        //        StreamApi, lambda를 활용한 내림차순 정렬
       /* int[] arr2={5,1,2,7,3,1,2};
        int[] new_arr2= Arrays.stream(arr2) //arr2를 대상으로 stream 객체 생성 문법
        int[] new_arr2= Arrays.stream(arr2).boxed() // int를 Integer로 형변환 스트림객체생성
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()) // 내림차순 정렬
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a) // Integer를 int로 변환
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray() // 배열로 변환


        //collect(변환할 컬렉션 객체 명시) :
        /*List<Integer> myList2= myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<String> stList = new ArrayList<>(Arrays.asList("java","python","C++","javascript","javascript"));*/
        //streamApi를 사용해서 문자열의 길이 4개 이상인, 문자열 길이를 기준으로 내림차순 정렬 후 신규 LIST 생성
        /*List<String> mynewlist= stList.stream().distinct().filter(a->a.length()>=4)
                .sorted((o1,o2)->o2.length()-o1.length()).collect(Collectors.toList());
        System.out.println(mynewlist);*/

        //3.map
        /*int[] arr_plus10= Arrays.stream(arr).map(a-> a+10).sorted().toArray();
        System.out.println(Arrays.toString(arr_plus10));*/
        //arr에서 짝수만 골라서 해당 수의 제곱의 총합을 구하라. sum()
        /*int answer= Arrays.stream(arr).filter(a->a%2==0).map(a->a*a).sum();  //Arrays.
        System.out.println(answer);*/

//       stream  최종연산 주요 메서드
        //forEach, reduce : 스트림 소모
        //1. forEach: 하나씩 뽑아서 (for문과 비슷)
        /*int [] arr={10,20,30,40};
        Arrays.stream(arr).forEach(a-> System.out.println(a));
        Arrays.stream(arr).forEach(System.out::println);  // 같은 말*/

        //2. reduce: 누적 연산
        //초기값을 지정하지 않으면 Optional객체 return
        //Optional객체: 값이 있을수도 있고 없을수도 있다는 것을 명시한 타입(java8 이후 추가)
        /*String st1= null;
        int [] arr={10,20,30,40};
        Optional<String> myOptional=Optional.ofNullable("hello");
        if(myOptional.isPresent()){
            System.out.println(myOptional.get().length());
        }
        int result = Arrays.stream(arr).reduce(1,(a,b)->a*b);
        System.out.println(result);
        int total= Arrays.stream(arr).reduce((a,b)->a+b).getAsInt();
        System.out.println(total);*/

        /*String [] stArr= {"hello", "java","world"};
        String answer= Arrays.stream(stArr).reduce((a,b)-> a+", "+ b).get();
        Optional<String> answer2= Arrays.stream(stArr).reduce((a,b)-> a+", "+ b);
        if(answer2.isPresent()){
            System.out.println(answer2.get());*/

        //3. count()
        //최소, 최대, 평균, 총합, 개수 : min/max/average/sum/count
        /*List<Integer> myList= new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(myList.stream().mapToInt(a->a).min().getAsInt());    // min, max, average, sum은 maptoint로 intstream으로 변환, 그래야 min, max, average, sum 사용 가능
        System.out.println(myList.stream().mapToInt(a->a).max());
        System.out.println(myList.stream().mapToInt(a->a).average().getAsDouble());
        System.out.println(myList.stream().mapToInt(a->a).sum());
        System.out.println(myList.stream().count());
        int minimum= myList.stream().mapToInt(a->a).min().getAsInt();
        int maximum= myList.stream().mapToInt(a->a).max().getAsInt();
        double average= myList.stream().mapToInt(a->a+a).average().getAsDouble();
        long count= myList.stream().count();*/

        //findfirst
        List<Student> myStudents = new ArrayList<>();
        myStudents.add(new Student("kim", 30));
        myStudents.add(new Student("lee", 14));
        myStudents.add(new Student("jeong", 25));
        myStudents.add(new Student("son", 34));
        myStudents.add(new Student("shin", 24));
       /* Student s1= myStudents.stream().filter(a->a.getAge()>30).findFirst().get();
        System.out.println(s1);*/
//        Student 객체 실습
//        1)가장 나이 어린 사람 찾기
        //내 답
        Student youngest = myStudents.stream().min((o1, o2) -> o1.getAge() - o2.getAge()).get();
        System.out.println(youngest);
        //강사님 답
        myStudents.stream().sorted(Comparator.comparingInt(Student::getAge)).findFirst().get();
        myStudents.stream().min((o1, o2) -> o1.getAge() - o2.getAge()).get();

//        2) 30대 몇명인지 출력
        long count = myStudents.stream().filter(a -> a.getAge() >= 30).count();
        System.out.println(count);

//        3) 모든 객체의 평균 나이 출력
        double average = myStudents.stream().mapToInt(a -> a.getAge()).average().getAsDouble();
        System.out.println(average);

//        4) 30세 이하 선착순 누구인지 출력
        Student first_30 = myStudents.stream().filter(a -> a.getAge() >= 30).findFirst().get();
        System.out.println(first_30);

//         기존의 java null
//        String st = null;
//        if (st != null) {
//            System.out.println(st.compareTo("abc"));
//        }
//       java 8 이후 나온 optional 객체를 통해 특저어 객체에 값이 없을지도 모른다는 것을 명시적으로 표현
        // Optional 객체에 빈 값을 명시적으로 넣는 방법: Optional.empty();
        Optional<String> opt1=Optional.empty();  // 문제를 발생시키는 빈값
        // 빈값인지 아닌지 체크하는 메서드가 isPresent()
//        System.out.println(opt1.get().compareTo("abc")); /*Exception in thread "main" java.util.NoSuchElementException: No value present
//        at java.base/java.util.Optional.get(Optional.java:148)
//        at C15AnonymousLambda.C1505StreamAPI1.main(C1505StreamAPI1.java:160)*/
//        if(opt1.isPresent()){
//            System.out.println(opt1.get().compareTo("abc"));
//        } else {
//            System.out.println("값이 없습니다.");
//        }
//      Optional 객체
        Optional<String> opt2 = Optional.ofNullable("hello"); //null이 있을수도 있음을 의미
        //1. isPresent()로 null 처리    -> 이건  코드가 많이 길어져서 지양하는 방식
       /* if(opt1.isPresent()){
            System.out.println(opt2);
        } else {
            System.out.println("값이 없습니다.");

        }*/
        //orElse 관련 메서드 사용하여 null(빈값) 처리
        //2. orElse(), orElseGet(), orElseThrow()
        //orElse(): 값이 있으면 해당 값 return, 없으면 default 지정값 return
//        System.out.println(opt2.orElse("").compareTo("abc"));   // 없으면 "" 로 나오게 함.
        //orElseGet(): 값이 있으면 해당 값 return, 없으면 매개변수로 람다함수 또는 메소드 참조
//        System.out.println(opt1.orElseGet(()->new String()).compareTo("abc"));
//        System.out.println(opt1.orElseGet(()->new String("abc")).compareTo("abc")); // 없으면 abc string으로 반환
//        System.out.println(opt1.orElseGet(String::new).compareTo("abc"));
        //orElseThrow(): 값이 있으면 해당 값 return, 없으면 지정된 예외 강제 발생
//        int result= opt1.orElseThrow(()->new NoSuchElementException("객체에 값이 없습니다.")).compareTo("abc");
//        System.out.println(result);

        //OptionalInt, OptionalDouble
        OptionalInt oi= new ArrayList<>(Arrays.asList(1,2,3,4)).stream().mapToInt(a->a).max();
        if(oi.isPresent()){
            System.out.println(oi);
        } else {
            System.out.println("값이 없습니다.");
        }
        //orelse 등의 방법 활용
        System.out.println(oi.orElseThrow(()->new NoSuchElementException("no value")));

    }
}


