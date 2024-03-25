package C14Interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListCompare {
    public static void main(String[] args) {
        long startTime= System.currentTimeMillis();
        List<Integer> myList = new LinkedList<>();
        for( int i=0; i<100000; i++){
            myList.add(0,10);
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);

        long startTime2= System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            myList.get(i);
        }
        long endTime2= System.currentTimeMillis();
        System.out.println(endTime2-startTime2);
    }
}
