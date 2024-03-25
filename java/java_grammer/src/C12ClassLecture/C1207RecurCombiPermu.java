package C12ClassLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1207RecurCombiPermu {
    static boolean [] visited;

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));  // 1,2,3,4
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        visited = new boolean[myList.size()];
        System.out.println(Arrays.toString(visited));
        permutation(3,temp,combinations, myList);
        System.out.println(combinations);
    }


    static void permutation(int n, List<Integer> temp, List<List<Integer>> combinations, List<Integer> myList) {
        if (temp.size() == n) {
            combinations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < myList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                temp.add(myList.get(i));
                permutation(n, temp, combinations, myList);
                temp.remove((temp.size() - 1));
                visited[i] = false;
            }
        }
    }
}