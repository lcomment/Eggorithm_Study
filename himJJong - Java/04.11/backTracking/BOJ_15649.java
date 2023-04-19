package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15649 {
    static boolean[] visited;
    static int[] NM;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        visited = new boolean[NM[0]+1];
        answer = new int[NM[1]];

        for(int i=1; i<=NM[0];i++){
            visited[i] = true;
            answer[0] = i;
            backTracking(0);
            visited[i] = false;
        }
        System.out.print(sb);
    }

    private static void backTracking(int depth) {
        if(depth+1 == NM[1]){
            for(int i=0; i<answer.length; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=NM[0] ; i++){
            if(!visited[i]){
                answer[depth+1] = i;
                visited[i] = true;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
