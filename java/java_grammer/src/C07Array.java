import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class C07Array {
    public static void main(String[] args) {
//        표현식1
        /*int[] int_arr1 = {1, 2, 3, 4};*/
//        int_arr1[1]; //2가 나옴
//        표현식2
        /*int[] int_arr2=new int[4];
        int_arr2[0]=1;
        int_arr2[1]=2;
        int_arr2[2]=3;
        int_arr2[3]=4;*/
//        표현식3
        /*   int[] int_arr3=new int[]{1,2,3,4};*/
//        표현식 4는 불가: java의 배열은 반드시 길이가 지정되어야 함.
//        int[] int_arr3 = new int[];
       /* String[] arr_st=new String[5];
        arr_st[0]="java";
        arr_st[1]="python";
        arr_st[2]="C++";
        for(int i=0; i<arr_st.length;i++){
            System.out.println(arr_st[i].length());
        }*/
        //null-point exception 이 생김, 빈 공간이 null값이기 때문
      /*  for(int i=0;i<arr_st.length;i++){
            if(arr_st[i].isEmpty()){
                System.out.println("비어있습니다."); //null 값 인지 못함
            }
        }
*/
//        85,65,90인 int 배열을 선언한 뒤, 총합, 평균값. for 문 이용
     /*   int [] arr={85,65,90};
        int total=0;
        for (int i=0; i< arr.length ; i++){
            total += arr[i];
        }
        int average_1 = total/arr.length;
        System.out.println(total);
        System.out.println(average_1);*/

//       최대값, 최소값
       /* int[] minmax= {10,20,30,12,8,17};
        int max=minmax[0];
        int min=minmax[0];
        for (int i=0; i< minmax.length ; i++){
            if(minmax[i]>=max){
                max=minmax[i];
            }
            if(minmax[i]<=min){
                min=minmax[i];
            }
            }
        System.out.println(max);
        System.out.println(min);*/

//        배열의 순서 바꾸기
       /* int[] arr = {10, 20};
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;*/


 /*       int[] arr2={10,20,30,40,50,60,70};
        int ini = arr2[0];
        int i = 0;
        while (i < arr2.length-1) {
            int temp=arr2[i+1];
            arr2[i+1] = arr2[i];
            arr2[i]=temp;
            i++;

        }
        arr2[arr2.length-1]=ini;
        System.out.println(Arrays.toString(arr2));*/

   /*     int[] arr3={10,20,30,40,50,60,70};
        int init = arr3[0];
        int j = 0;
        for(j=0;j<arr3.length-1;j++){
            int temp = arr3[j];
            arr3[j]=arr3[j+1];
            arr3[j+1]= temp;
        }
        arr3[arr3.length-1]=init;
        System.out.println(Arrays.toString(arr3));*/
//  배열뒤집기
        /*int [] arr={1,2,3,4,5};*/
        //  신규배열 선언 : arr2 :
        /*int [] arr2=new int[arr.length];
        for (int i=0; i<arr.length;i++) {
            System.out.println(i);
            arr2[i]=arr[arr.length-1-i];
        }
        System.out.println(Arrays.toString(arr2));*/

/*        int [] arr3=new int[arr.length];
        int i=0;
        while(i<arr.length){
            arr3[i]=arr[arr.length-1-i];
            i++;
        }
        System.out.println(Arrays.toString(arr3));*/

//  배열 뒤집기2
        /* int [] arr={1,2,3,4,5};*/
//        int [] arr2=new int[arr.length];
      /*  for(int i=0; i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        System.out.println(Arrays.toString(arr));*/

        /*int j=0;
        while(j<arr.length/2){
            int temp=arr[j];
            arr[j]=arr[arr.length-1-j];
            arr[arr.length-1-j]=temp;
            j++;
        }
        System.out.println(Arrays.toString(arr));*/
//정렬: sort() 함수 사용
        //오름차순
       /* int[] arr={1,6,2,4,7,5,5,2,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));*/

        //내림차순
//        방법1. Comparator 객체 사용
//        객체타입인 경우에만 Comparator 클래스 사용 가능
        String[] st_arr={"hello","hi","bye","goodmorning"};
        Arrays.sort(st_arr);
        System.out.println(Arrays.toString(st_arr));
        Arrays.sort(st_arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(st_arr));
        Integer[] arr_integer = {5,1,2,7,4,1,2};
        Arrays.sort(arr_integer,Comparator.reverseOrder());
//        comparator 클래스는 기본형 타입은 처리 불가
//        Arrays.sort(arr, Comparator.reverseOrder());
//        방법2. 배열 뒤집기
        /*int[] arr={1,6,2,4,7,5,5,2,3};
        Arrays.sort(arr);
        for (int i=0; i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        System.out.println(Arrays.toString(arr));*/

//        StreamApi, lambda를 활용한 내림차순 정렬
       /* int[] arr2={5,1,2,7,3,1,2};
        int[] new_arr2= Arrays.stream(arr2) //arr2를 대상으로 stream 객체 생성 문법
        int[] new_arr2= Arrays.stream(arr2).boxed() // int를 Integer로 형변환 스트림객체생성
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()) // 내림차순 정렬
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a) // Integer를 int로 변환
        int[] new_arr2= Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray() // 배열로 변환
*/
//  선택 정렬
      /*  int[] array = {30, 22, 20, 25, 12};
        for(int i=0; i< array.length;i++){
            int min = array[i];
            int index=i;
            for (int j=i+1,j)*/

        //오름차순
/*        int[] array = {30, 22, 20, 25, 12};
        for (int i = 0; i < array.length - 1; i++) {         // 자리를 찾는 for 문
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));*/

        //내림차순
      /*  int[] array2 = {30, 22, 20, 25, 12};
        for (int i = 0; i < array2.length; i++) {         // 자리를 찾는 for 문
            for (int j = i + 1; j < array2.length; j++) {
                if (array2[i] < array2[j]) {
                    int temp = array2[i];
                    array2[i] = array2[j];
                    array2[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array2));*/

//        숫자 조합의 합: 각기 다른 숫자의 배열이 있을때 만들어 질 수 있는 2개의 조합의 합을 출력하라.
        /* int[] int_arr = {10, 20, 30, 40, 50, 60};
         *//* int n=0;*//*
         *//*   int [] sum= new int[15];*//*
        for (int i = 0; i < int_arr.length; i++) {
            for (int j = i + 1; j < int_arr.length; j++) {
             *//*  sum[n]= int_arr[i]+int_arr[j];
                n++;*//*
                System.out.println(int_arr[i] + " + " + int_arr[j] + "=" + (int_arr[i] + int_arr[j]));
            }
        }
        *//* System.out.println(Arrays.toString(sum));*/

//        중복 제거하기
        /*int[] temp={10,10,40,5,7,10};
        int[] new_temp= new int [temp.length];
        for(int i=0;i< temp.length;i++){

        }
        */
        int[] temp={10,10,5,7,10,40};
        Arrays.sort(temp);
        int[] new_temp=new int[temp.length];
        int n=0;
        for(int i=0; i<temp.length-1;i++){

            if(temp[i]!=temp[i+1]){
               new_temp[n]=temp[i];
               n++;
               }
            }
        int [] answer=Arrays.copyOfRange(new_temp,0,n);
        System.out.println(Arrays.toString(answer));

        //프로그래머스 두개 뽑아서 더하기
        /*int [] numbers={2,1,3,2,1};
        int [] numbers_combination= new int [numbers.length* numbers.length-1];
        int combination_Count=0;
        for( int i=0; i<numbers.length-1;i++){
            for(int j=i+1; j<numbers.length;j++){
                numbers_combination[combination_Count]= numbers[i]+numbers[j];
                combination_Count++;
            }
        }
        int [] temp = Arrays.copyOfRange(numbers_combination,0,combination_Count);*/

// 버블 정렬
        /*int[] arr={1,2,4,7,8};
        for(int i=0; i< arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/
/*        int[] arr={5,1,2,3,4};
        for(int i=0; i< arr.length-1; i++){
//                boolean isChanged==false;
            for(int j=0; j<arr.length-1-i; j++) {
                int count=0;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
//                    isChanged==true;
                if(count==0){           //if(isChanged==false)
                    break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/
//     배열의 검색
        /*int[] arr= {5,3,1,8,6};
        int answer=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==8){
                answer=i;
            }
        }
        System.out.println(answer);      */       // 복잡도가 높음 O(n) -> n 만큼 뒤져야 함.
        // 이진 검색 binary search
        // 사전에 오름차순 정렬이 되어 있어야 이진 검색 가능.
        //
     /*   int[] arr = {1, 3, 6,8, 9, 11};
//        1) 정렬이 되어 있어야 한다.
//        2) 이진 검색 알고리즘
        *//*Arrays.sort(arr);*//*
        int answer = Arrays.binarySearch(arr, 8);
        System.out.println(answer);*/
//  배열간의 비교 : equals, 순서까지 동일해야 true
    /*    int [] arr1={10,20,30};
        int [] arr2={20,30,10};
        System.out.println(Arrays.equals(arr1,arr2));
        int [] arr3={10,20,30};
        int [] arr4={10,20,30};
        System.out.println(Arrays.equals(arr3,arr4));*/
//  배열 복사 : copyOf(배열, endIndex), copyOfRange(배열, start, end)
       /* int [] arr={10,20,30};
        int[] new_arr1 = Arrays.copyOf(arr, 10);
        int [] new_arr2 = Arrays.copyOfRange(arr, 1,4);
        System.out.println(Arrays.toString(new_arr1));
        System.out.println(Arrays.toString(new_arr2));*/
//    2차원 배열 할당
//    {{1,2,3},{4,5,6}}
       /* int[][] arr=new int[2][3];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
        System.out.println(Arrays.deepToString(arr));*/
//  2차원 가변배열 선언 및 할당
        /*int [][] arr2=new int[3][];     //앞 배열 비워두고 뒤 배열 채우면 안되지만 앞 배열 할당하고 뒤 배열 유연하게 두는 건 가능
        arr2[0]=new int [1];
        arr2[1]=new int [2];
        arr2[2]=new int [3];*/
      /*  arr2[0][0]=10;
        arr2[1][0]=20;
        arr2[2][0]=30;*/            //크기를 지정하지 않은 상태에서 값을 직접 지정하는 방식은 안된다.
//  가변 배열 리터럴 방식
        /*int[][] arr3={{10},{10,20},{10,20,30}};
        System.out.println(Arrays.deepToString(arr3));*/

//  실습 예제: [3][4]사이즈의 배열을 선언한 뒤
//  1,2,3~12까지의 숫자값 각 배열에 할당
      /*  int[][] my_arr=new int[3][4];
        int n=1;
        for(int i=0; i<my_arr.length;i++){
            for(int j=0; j< my_arr[i].length; j++){
                my_arr[i][j]=n;
                n++;
            }
        }
        System.out.println(Arrays.toString(my_arr));
        System.out.println(Arrays.deepToString(my_arr));*/

//       가변 배열 만들기: 전체사이즈 5
//        각 배열마다 사이즈가 1,2,3,4,5로 커지도록 : for 문
//        각 사이즈별로 1은 10이 모두 들어가고, 2는 20이 모두 들어가고 3은 30이 모두 들어가도록
        int[][] my_arr1 = new int[5][];
        int count=1;
        for (int i = 0; i < my_arr1.length; i++) {
            my_arr1[i] = new int[i + 1];
            for (int a = 0; a < my_arr1[i].length; a++) {
                my_arr1[i][a] = count * 10;
            }
            count++;
        }
            System.out.println(Arrays.deepToString(my_arr1));
        }
    }
