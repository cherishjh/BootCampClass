package C12ClassLecture;


/*public class temp {
    static int answer;
    static boolean [] visited;

    public static void main(String[] args) {
        int k=80;
        int [][] dungeons={{80,20},{50,40},{30,10}};
        int count=0;
        int sum=0;
        visited=new boolean[dungeons.length];
        adventure(k,count,sum,dungeons);
        System.out.println(answer);
    }

    static void adventure(int k, int i, int sum, int[][] dungeons ){
        if(answer==dungeons.length) {
            return;
        }
        for(i=0;i<dungeons.length;i++) {
            sum += dungeons[i][0];
            if(visited[i]==false && sum<=k){
                answer++;
                visited[i] = true;
                adventure(k-sum,i+1,sum, dungeons);
                answer--;
                visited[i]=false;
                }
            }
        }*/
   class Solution {
       static int answer = 0;
       static int temp = 0;

       public int solution(int k, int[][] dungeons) {
           boolean[] visited= new boolean[dungeons.length];
           Solution main = new Solution();
           main.d(80, dungeons, visited);
           return answer;
       }
       void d (int k, int[][] dungeons, boolean[] visited) {
           if(temp > answer) {
               answer = temp;
           }
           if(answer==dungeons.length){
               return;
           }
           for (int i = 0; i < dungeons.length; i++) {
               if (!visited[i] && k >= dungeons[i][0]) {
                   visited[i] = true;
                   temp++;
                   k -= dungeons[i][1];
                   d (k, dungeons, visited);
                   visited[i] = false;
                   temp--;
                   k += dungeons[i][1];
               }
           }
       }
   }




