import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BFS_programmers_gameMap {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int n = maps.length;
        int m = maps[0].length;
        adjList = new ArrayList<>();
        visited = new boolean[n * m];
        distance= new int [n*m];
        for (int i = 0; i < n * m; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 0) continue;
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};
                for (int d = 0; d < 4; d++) {
                    int target_i = i + dx[d];
                    int target_j = j + dy[d];
                    if (target_i >= 0 && target_i < m && target_j >= 0 && target_j < n && maps[i][j]==1) {
                        addEdge((i ) * n + j, (target_i) * n + target_j);
                    }
                }
            }
        }
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int target : adjList.get(next)) {
                if (visited[target] == false) {
                    queue.add(target);
                    distance[target] = distance[next] + 1;
                    visited[target] = true;
                    if (target == end) {
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}
