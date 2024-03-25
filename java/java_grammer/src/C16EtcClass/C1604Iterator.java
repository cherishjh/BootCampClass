package C16EtcClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C1604Iterator {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("butter");
        myList.add("PTD");
        myList.add("dynamite");

        //enhanced for 문: 원본이 변경되지 않음 -> remove 불가 (!)
       /* for(String s: myList){
            System.out.println(s);*/
        // remove 메서드 없음

        //iterator 사용 : 참조하고 있는 원본데이터 사용 가능 -> remove
        Iterator<String> iter = myList.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals("butter")) {
                iter.remove();
            }
        }
        System.out.println(myList);
    }
}