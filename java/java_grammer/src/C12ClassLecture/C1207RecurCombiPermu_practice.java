package C12ClassLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1207RecurCombiPermu_practice {
    static boolean[] visited;
    static int total_sum = 0;
    static int count=0;
    static int answer=0;

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));  // 1,2,3,4
        List<List<Integer>> combinations = new ArrayList<>();
        List<List<Integer>> combinations2 = new ArrayList<>();
        List<List<Integer>> combinations3 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        
        visited = new boolean[myList.size()];
        permutation1(2, 4, 0, temp, combinations, myList);

        for(int count=1; count<myList.size(); count++){
            permutation2(count,0,0,temp2,  combinations2, myList);
        }

        permutation3(0,count,combinations3, myList);

//        permutation3(2, 6, 0, temp, combinations, myList);
        System.out.println(combinations);
        System.out.println(combinations2);
        System.out.println(answer);
    }

    static void combination(int count, List<Integer> temp, int n, List<List<Integer>> combinations, List<Integer> myList) {
        if (temp.size() == n) {
            combinations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = count; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combination(i + 1, temp, n, combinations, myList);
            temp.remove((temp.size() - 1));
        }
    }

    static void permutation1(int n, int total, int sum, List<Integer> temp, List<List<Integer>> combinations, List<Integer> myList) {
        if (temp.size() == n) {
            for (int i : temp) {
                sum += i;
            }
            if (sum >= total) {
                combinations.add(new ArrayList<>(temp));
                return;
            }
        }
        for (int i = 0; i < myList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                temp.add(myList.get(i));
                permutation1(n, total, sum, temp, combinations, myList);
                temp.remove((temp.size() - 1));
                visited[i] = false;
            }
        }
    }

    static void permutation2(int count, int total, int sum,List<Integer> temp2, List<List<Integer>> combinations2, List<Integer> myList) {
        if (temp2.size() == count) {
            for (int i : temp2) {
                sum += i;
            }
            if (sum >= total) {
                combinations2.add(new ArrayList<>(temp2));
            }
        }
        for (int i = 0; i < myList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                temp2.add(myList.get(i));
                permutation2(count, total, sum, temp2, combinations2, myList);
                temp2.remove((temp2.size() - 1));
                visited[i] = false;
            }
        }
    }

    static void permutation3(int temp,int count,List<List<Integer>> combinations3, List<Integer> myList) {
        if (count==3) {
            if(temp>answer){
                answer=temp;
            }
            return;
        }
        for (int i = 0; i < myList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                temp+=myList.get(i);
                permutation3(temp,count+1,combinations3, myList);
                temp-=myList.get(i);
                visited[i] = false;
            }
        }
    }
}
