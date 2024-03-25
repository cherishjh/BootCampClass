package C16EtcClass;

import java.util.Arrays;

public class C1603GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java", "python", "C++"};
        /*for (int i = 0; i < stArr.length - 1; i++) {
            String temp = stArr[i];
            stArr[i] = stArr[i + 1];
            stArr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(stArr));*/

        Integer[] intArr = {1, 2, 3, 4, 5};     // 여기서는 전체를 바꾸는게 아니라서 for 문까지는 안 써도 됨 (강사 comment)
     /*   for (int i = 0; i < intArr.length - 1; i++) {
            int temp = intArr[i];
            intArr[i] = intArr[i + 1];
            intArr[i + 1] = temp;
        }*/
//        changeInt(intArr,2,3);
//        changeString(stArr,0,1);
        Swap(intArr,1,2);
        System.out.println(Arrays.toString(intArr));

        GenericStudent<String> gs1= new GenericStudent<>();
        gs1.setAge("21");
        System.out.println(gs1.getAge().getClass());

        GenericStudent<Integer> gs2= new GenericStudent<>();
        gs2.setAge(28);
        System.out.println(gs2.getAge());
    }


//      제네릭 메서드 생성: 반환 타입 왼쪽에 <T> 선언
    //일반 메서드로 구현해보기
       /* static void changeInt(Integer[] intArr, int a, int b){
            int temp= intArr[a];
            intArr[a]= intArr[b];
            intArr[b]= temp;
        System.out.println(Arrays.toString(intArr));
        }
        static void changeString(String[] strArr, int a, int b){
            String temp= strArr[a];
            strArr[a]= strArr[b];
            strArr[b]= temp;
        System.out.println(Arrays.toString(strArr));
    }*/

    //제네릭 메서드 생성
        //제네릭은 객체 타입이 들어와야 함에 유의
        // 메서드 명 앞에 <T>
         static <T> void Swap(T[] arr, int a, int b){
             T temp= arr[a];
             arr[a]= arr[b];
             arr[b]= temp;
         }
    }

    //제네릭 클래스 생성 : 클래스 명 옆에 <T>
    class GenericStudent <T>{
        String name;
        T age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getAge() {
            return age;
        }

        public void setAge(T age) {
            this.age = age;
        }
    }
