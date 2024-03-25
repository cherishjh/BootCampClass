import java.util.ArrayList;
import java.util.List;

public class DFSArrayGraph_List {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5;
        adjList = new ArrayList<>();
        visited = new boolean[node_n];
        for (int i = 0; i < node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : inputArr) {
            addEdge(a[0], a[1]);
        }
        System.out.println(adjList);
        dfs( 0);
    }


    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void dfs(int start) {
        System.out.print(start + ", ");
        for (Integer target : adjList.get(start)) {
            visited[start] = true;
            if (visited[target] == false) {
                visited[target] = true;
                dfs(target);
            }
        }
    }
}

   /* static void dfs(List<List<Integer>> adjList, int start) {
        visited[start] = true;
        System.out.println(start);
        for (int i = 0; i < adjList.get(i).size(); i++) {
                if (visited[adjList.get(start).get(i)] == false) {
                    dfs(adjList, adjList.get(start).get(i));
                }
            }
        }*/

