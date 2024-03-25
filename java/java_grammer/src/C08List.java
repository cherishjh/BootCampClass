import java.util.*;
import java.util.stream.Collectors;

public class C08List {
    public static void main(String[] args) {
//        list 선언 방법
        //ArrayList<String> myList=new ArrayList<String>();
//        ArrayList<String> myList=new ArrayList<>();  // 가장 일반적인 방식
        //왼쪽에는 인터페이스, 오른쪽에는 구현체
//        List<String> my_List= new ArrayList<>();

//       초기값 생성 방법1. 하나씩 add
       /* ArrayList<String> myList=new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("C++");
        System.out.println(myList);*/

//        초기값 생성 방법2. 한번에 add
        /*String [] myArr1={"java","python","and more"};*/
//        ArrayList<String> myList=new ArrayList<>(Arrays.asList("java","python","and more"));
       /* ArrayList<String> myList=new ArrayList<>(Arrays.asList(myArr1));   // 배열
        System.out.println(myList);*/
//      배열이 int인 경우 문제 -> 형변환 이슈 발생
        /*int [] myIntArr1={1,2,3};*/
//        List<Integer> myIntList1= new ArrayList<>(Arrays.asList(myIntArr1));
        /*List<Integer> myIntList1= new ArrayList<>();
        for (int a : myIntArr1){        //하나씩 더해주면 알아서 autoboxing 됨
            myIntList1.add(a);
        }*/
        /*List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);*/
//        add(int index, int element): 중간에 값 삽입은 기본적으로 성능 저하
       /* myList.add(1, 15);
        System.out.println(myList);*/
       /* List<Integer> myList2 = new ArrayList<>();
        myList2.add(30);
        myList2.add(40);
        myList2.add(50);
        System.out.println(myList2);*/
//        addAll(Collection객체): 특정 리스트의 요소를 모두 add
       /* myList.addAll(myList2);
        System.out.println(myList);*/
//  get(int index) : 특정 위치의  요소를 반환
        /*System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
        System.out.println(myList.get(4));
        System.out.println(myList.get(5));*/

        /*for (int i = 0; i < 6; i++) {
            System.out.println(myList.get(i));
        }*/
        //  size() : 리스트 개수 반환
        /*for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }*/
//  remove: 요소 삭제
        // remove는 value 삭제, index를 통한 삭제


        //remove를 통한 index 삭제: 0번째
        /*myList.remove(0);
        System.out.println(myList);*/
        // 객체를 통한 삭제: Integer.valueOf
//        myList.remove(Integer.valueOf(15));
//        System.out.println(myList);

        /*List<Integer> myP= new ArrayList<>();
        myP.add(20);
        myP.add(30);
        myP.add(30);
        myP.add(40);
        System.out.println(myP);
        myP.remove(Integer.valueOf(30));
        System.out.println(myP);*/
        //set(int index, E element): index 자리에 값 변경
        //마지막 자리값: 100으로 셋팅 후 출력
        /*myList.set(myList.size()-1,100 );
        System.out.println(myList);*/

        //contains(E element): 특정 값이 있는지 없는지 boolean return
        /*System.out.println(myList.contains(30));*/

      /*  List<Integer> myList=new ArrayList<>();
        myList.add(10);
        myList.add(10);
        myList.add(20);
        myList.add(30);*/
//        indexOf: 몇번째 index에 위치한지 return, 요소가 없으면 -1 return
        //중복되는 값이 있으면 가장 첫번째 값을 return
        /*System.out.println(myList.indexOf(20));
        System.out.println(myList.isEmpty());*/
//        전체 삭제 clear()
        /*myList.clear();
        System.out.println(myList);*/
//      isEmpty: 값이 비었는지 안 비었는지
        /*System.out.println(myList.isEmpty());*/
//      리스트에 배열 담기
        /*List<int[]> myList = new ArrayList<>();

        myList.add(new int[]{1,2,3});
        myList.add(new int[2]);
        myList.add(new int[3]);
        myList.get(1)[0]=10;
        myList.get(1)[1]=20;*/
        /*for(int a=0; a<myList.size();a++){
            System.out.print(Arrays.toString(myList.get(a)));
        }*/
       /* for(int [] a: myList){
            System.out.println(Arrays.toString(a));*/

//  리스트 출력
        List<List<Integer>> myList2= new ArrayList<>();
        myList2.add(new ArrayList<>(Arrays.asList(1,2,3)));
        myList2.add(new ArrayList<>(Arrays.asList(10,20,30)));
        myList2.add(new ArrayList<>(Arrays.asList(100,200,300)));
        for(int i=0; i<myList2.size();i++){
            myList2.get(i).add(10);
        }
        System.out.println(myList2);
        //아래 리스트에 값 1,2,3 10,20,30  100,200,300 할당
        /*List<int[]> myList2= new ArrayList<>();
        myList2.add(new int[1]);
        myList2.add(new int[2]);
        myList2.add(new int[3]);*/

        /*myList2.add(new ArrayList<>(Arrays.asList(1,2,3)));
        myList2.add(new ArrayList<>(Arrays.asList(10,20,30)));
        myList2.add(new ArrayList<>(Arrays.asList(100,200,300)));*/
        /*int value=1;
        for(int i=0; i<myList2.size();i++){
            for(int j=0; j< myList2.get(i).length;j++){
                myList2.get(i)[j]=(j+1)*value;
            }
            value *=10;
        }
        System.out.println(myList2);*/
//      List<Integer> myList= new ArrayList<>(Arrays.asList(5,3,1,2,5));
//      리스트 정렬 1: Collections.sort();
        /*Collections.sort(myList);
        System.out.println(myList);
        Collections.sort(myList,Comparator.reverseOrder());
        System.out.println(myList);*/
//       리스트 정렬 2: 객체.sort();
        /*myList.sort(Comparator.naturalOrder());
        System.out.println(myList);
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);*/

//        1. String 배열을 list로 변환
        String[] my_str = {"java", "python", "mylang"};
        //1-1 Arrays.asList
        List<String> list = new ArrayList<>(Arrays.asList(my_str));
        //1-2 for 문 담기
        List<String> list2 = new ArrayList<>();
        for (String a : my_str) {
            list2.add(a);
        }
        //1-3 streamApi
        List<String> my_list = Arrays.stream(my_str).collect(Collectors.toList());//collectors -> list 형으로 변환

//       2.  int 배열을 list로 변환
        //2-1 Arrays.asList: 사용 불가
        //2-2 for 문 담기 가능
        //2-3 streamApi 사용 가능

//       3. String리스트를 String 배열로 변환
        /*List<String> convert = new ArrayList<>(Arrays.asList("java","happy","welcome"));
        String [] result= new String[convert.size()];
        for(int i=0; i<convert.size();i++){
                    fresult[i]=convert.get(i);
        }
        System.out.println(Arrays.toString(result));*/

//      4. int 리스트를 int 배열로 변환
        //4-1 for 문으로 변환
        //4-2 streamApi로 변환

        //두개 뽑아서 더하기: 리스트로 풀어보기
//        int[] numbers = {2, 1, 3, 4, 1};
//        List<Integer> myList = new ArrayList<>();
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                int sum = numbers[i] + numbers[j];
//                if()
//                myList.add(sum);
//            }
//        }
//        myList.sort(Comparator.naturalOrder());
//        List<Integer> new_list = new ArrayList<>();
//        for (int a : myList) {
//            if (!new_list.contains(a)){
//                new_list.add(a);
//            }
//        }
//        System.out.println(new_list);
    }
}