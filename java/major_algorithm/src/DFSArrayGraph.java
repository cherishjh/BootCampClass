import java.util.Arrays;

public class DFSArrayGraph {
    static boolean [] visited;

    public static void main(String[] args) {
       int [][] graph=              //재귀 호출할때마다 만들어야하니까 낭비 --> static으로 올리는게 나음 .
        {{0, 1, 1, 0, 0},
        {1, 0, 0, 1, 0},
        {1, 0, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {0, 0, 1, 0, 0}};
       int [] answer = new int [graph.length];
       visited = new boolean[graph.length];

       dfs(graph,0,0, answer);
        System.out.println(Arrays.toString(answer));
       }

    static void dfs(int [][] graph, int start, int k, int [] answer ) {
        visited[start]=true;
        answer[k]=start;
        for(int i = 0; i<graph[start].length ;i++ ){
            if(visited[i]==false && graph[start][i]==1){        //start 값은 시작하는 node, i는 그 다음 node
                dfs(graph,i,k+1,answer);
            }
        }
    }
}
