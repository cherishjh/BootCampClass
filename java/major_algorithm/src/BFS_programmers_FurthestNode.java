import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_programmers_FurthestNode {
    static List<List<Integer>> connection;
    static boolean [] visited;
    static int[] distance;

    public static void main(String[] args) {
        int n=6;
        int [][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        for(int i=0; i<n; i++){
            connection.add(new ArrayList<>());
        }
        for (int j=0; j<vertex.length; j++){
            connection.get(vertex[j][0]).add(vertex[j][1]);
            connection.get(vertex[j][1]).add(vertex[j][0]);
        }
        distance= new int [n-1];

    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start]=true;
        queue.add(start);
        while(!queue.isEmpty()){
            int next= queue.poll();
            for(int a: connection.get(next)){
                if(visited[a]==false){
                    queue.add(a);

                    visited[a]=true;
                    }
                }
            }
        }
}
