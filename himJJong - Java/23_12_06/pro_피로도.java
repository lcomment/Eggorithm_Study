public class pro_피로도 {
    public static void main(String[] args) {
        int[][] a = {{80,20},{50,40},{30,10}};
        System.out.println(Solution.solution(80,a));
    }
}
class Solution {
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        for(int i=0; i<dungeons.length; i++){
            if(k >= dungeons[i][0]){
                visited[i] = true;
                answer = Math.max(answer,btk(i,k-dungeons[i][1], dungeons, 1));
                visited[i] = false;
            }
        }
        return answer;
    }

    private static int btk(int start, int cur, int[][] dungeons, int count){
        result = Math.max(result, count);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && cur>=dungeons[i][0]){
                visited[i] = true;
                btk(start,cur - dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
        return result;
    }
}