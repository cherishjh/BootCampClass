import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

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

//        for ( int i=0; i<(높이 길이; 행의 개수); i){
//            for (int j=0; j<(가로 길이; 열의 개수); j ){
//        1) 시작노드 표현식: (i-5) * (열의 개수) + j
//        2) 타겟의 번호와 타겟의 유효성(2)
//            2-1) 타겟의 번호: j에 -1 빼면 왼쪽, j 에서 1 더하면 오른쪽 등
//            2-2) 타겟의 유효성: i 와 j 가 상하좌우 길이 체크
//            상하좌우 체크 로직
            /*  int [] dx= {-1,1,0,0};
              int [] dy = {0,0,-1,1};
              for(int d=0; d<4; d++){
                  int target_i = i+dx[d];
                  int target_j = j+dy[d];
                  if(target_i>=1 && target_i<=3 && target_j>=1 && target_j<=5){
                      addEdge((i-1)*5+j, (target_i-1)*5+target_j);
                  }
              }*/

       /* distance = new int[node_n];
        int target = (inputArr[i] - 5) * (2) + j;
        int shortest = bfs(0, target);
        System.out.println(shortest);
*/

    }

    //  start에서 target 위치까지 갈때, 최단거리 구하기
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


    /* static void bfs(int start){
         Queue<Integer> queue = new LinkedList<>();
         visited[start]=true;
         queue.add(start);
         while(!queue.isEmpty()){
             int next =queue.poll();
             System.out.print(next+" ");
             for(int target: adjList.get(next)){
                 if(visited[target]==false){
                     queue.add(target);
                     distance[target]=distance[next]+1;
                     visited[target]=true;
                 }
             }
         }
     }*/
    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}

